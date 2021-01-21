package com.axsosplatform.axsosplatform;

import com.axsosplatform.axsosplatform.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class AxsosplatformApplication {

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
