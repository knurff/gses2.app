package com.example.goes2.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;

@Configuration
public class FileDBConfiguration {

    @Value("${filedb.path}")
    private String path;

    @Bean
    public Path path(){
        return Path.of(path);
    }
}
