package com.example.goes2.service;

import com.example.goes2.exceptions.EmailAlreadySubscribed;
import com.example.goes2.model.Rate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SubscribeService {

    private final Path path;
    private final EmailSender emailSender;
    private final RateService rateService;

    @Autowired
    public SubscribeService(Path path, EmailSender emailSender, RateService rateService) {
        this.path = path;
        this.emailSender = emailSender;
        this.rateService = rateService;
    }

    public void subscribe(String email) {
        if (!checkEmailAlreadyExist(email))
            addEmailToFile(email);
        else throw new EmailAlreadySubscribed("Email already subscribed");
    }

    private boolean checkEmailAlreadyExist(String email) {
        if (Files.exists(path))
            try {
                for (String s : Files.readAllLines(path))
                    if (s.equals(email)) return true;
            } catch (IOException e) {
                log.error(e.getMessage());
                throw new RuntimeException(e);
            }
        return false;
    }

    private void addEmailToFile(String email) {
        try {
            StandardOpenOption option = Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE;
            Files.writeString(path, email + "\n", option);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<String> sendEmails() {
        List<String> errorEmails = new ArrayList<>();
        Rate rate = rateService.getRate();
        try {
            for (String s : Files.readAllLines(path)) {
                try {
                    emailSender.sendSimpleEmail(s, "Actual BTC to UAH rate", "Actual BTC price: "
                            + rate.getPrice() + " UAH");
                } catch (MailException e) {
                    errorEmails.add(s);
                    log.error(e.getMessage());
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return errorEmails;
    }
}
