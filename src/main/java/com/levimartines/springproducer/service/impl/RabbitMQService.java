package com.levimartines.springproducer.service.impl;

import com.levimartines.springproducer.amqp.AmqpProducer;
import com.levimartines.springproducer.dto.Message;
import com.levimartines.springproducer.service.AmqpService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService implements AmqpService {

    private final AmqpProducer<Message> producer;

    public RabbitMQService(
        @Qualifier("producerRabbitMQ") AmqpProducer<Message> producer) {
        this.producer = producer;
    }

    @Override
    public void sendToConsumer(Message message) {
        producer.producer(message);
    }
}
