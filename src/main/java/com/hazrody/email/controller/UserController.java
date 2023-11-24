package com.hazrody.email.controller;

import com.hazrody.email.model.User;
import com.hazrody.email.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
public class UserController {


    @Autowired
    UserService userService;

    @RabbitListener(queues = "user-queue")
    public void receiveMessageFromRabbitMQ(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(message, User.class);
            System.out.println("Message from rabbitmq: " + user.getEmail());
            userService.sendEmail(
                    user.getEmail(),
                    "Nouvelle utilisateur ajouté",
                    "L'utilisateur " + user.getName() + " " + user.getFirstName() + " vient d'être ajouté.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
