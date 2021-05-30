package com.levimartines.springproducer.service;

import com.levimartines.springproducer.dto.Message;

public interface AmqpService {

    void sendToConsumer(Message message);

}
