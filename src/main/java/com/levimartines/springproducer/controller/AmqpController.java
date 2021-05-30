package com.levimartines.springproducer.controller;

import com.levimartines.springproducer.dto.Message;
import com.levimartines.springproducer.service.AmqpService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmqpController {

    private final AmqpService amqpService;

    public AmqpController(AmqpService amqpService) {
        this.amqpService = amqpService;
    }

    @PostMapping("send")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendToConsumer(@RequestBody Message message) {
        amqpService.sendToConsumer(message);
    }
}
