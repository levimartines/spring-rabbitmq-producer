package com.levimartines.springproducer.amqp.impl;

import com.levimartines.springproducer.amqp.AmqpProducer;
import com.levimartines.springproducer.dto.Message;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("producerRabbitMQ")
public class ProducerRabbitMQ implements AmqpProducer<Message> {

    private final RabbitTemplate template;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;
    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    public ProducerRabbitMQ(RabbitTemplate template) {
        this.template = template;
    }

    @Override
    public void producer(Message message) {
        try {
            template.convertAndSend(exchange, queue, message);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
