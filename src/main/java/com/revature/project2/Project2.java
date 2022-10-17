package com.revature.project2;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.core.appender.RollingFileAppender;
import org.apache.tomcat.jni.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.context.annotation.Bean;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;

@SpringBootApplication // implies @Configuration @ComponentScan and @AutoConfiguration
public class Project2 {

    public static void main(String[] args) {
        SpringApplication.run(Project2.class, args);
        System.out.println(doHashing("passw0rd"));

    }
    public static String doHashing(String password) {
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");

            messageDigest.update(password.getBytes());

            byte[] resultByArray = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for (byte b : resultByArray) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
            return "";

    }

    @Bean
    public ObjectMapper jsonMapper() {
        return new ObjectMapper();
    }

}
