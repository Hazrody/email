package com.hazrody.email.controller;

import com.hazrody.email.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
public class UserController {

    @RabbitListener(queues = "user-queue")
    public void receiveMessageFromRabbitMQ(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(message, User.class);
            System.out.println("Message from rabbitmq: " + user.getEmail());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
