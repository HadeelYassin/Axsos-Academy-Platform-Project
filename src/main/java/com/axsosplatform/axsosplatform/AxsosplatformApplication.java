package com.axsosplatform.axsosplatform;

import com.axsosplatform.axsosplatform.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Random;

@SpringBootApplication
public class AxsosplatformApplication {
    @Autowired
    private SendEmailService sendEmailService;

    public static void main(String[] args) {

        SpringApplication.run(AxsosplatformApplication.class, args);

    }



//@EventListener(ApplicationReadyEvent.class)
//    public void triggerwhenStarts(){
//        sendEmailService.sendEmail("i7i@hotmail.ch", "I hope this will work good bye", "Hello");
//
//
//}
}
