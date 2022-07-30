# gses2.app


## About
In this project, I implemented the advanced system requirements of the task, which can be found at the [link](https://github.com/AndriiPopovych/gses/blob/main/gses2swagger.yaml).
This is a simple REST API that allows the user to get the current bitcoin to hryvnia exchange rate, subscribe to the newsletter of the current rate and send the current rate to all subscribers.

## Remark

* Now in the file ```gses2.app.jar``` there is a working version of the program, which uses Google SMTP service, but after a certain period of time will be replaced by one that is not tied to specific data, then you will need to create a new ```.jar``` by entering the correct data in the file ```application.properties```.
* I have not been able to configure Docker so that the host is ```gses2.app```, so you have to go to ```http://localhost/``` to use the application.











