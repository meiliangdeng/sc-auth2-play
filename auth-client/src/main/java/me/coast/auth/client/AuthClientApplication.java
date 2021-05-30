package me.coast.auth.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Client
public class AuthClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthClientApplication.class, args);
    }
}
