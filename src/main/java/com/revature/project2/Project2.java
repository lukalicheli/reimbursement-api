package com.revature.project2;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication // implies @Configuration @ComponentScan and @AutoConfiguration
public class Project2 {

    public static void main(String[] args) {
        SpringApplication.run(Project2.class, args);

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
