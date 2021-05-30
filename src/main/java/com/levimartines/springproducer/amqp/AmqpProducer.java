package com.levimartines.springproducer.amqp;

public interface AmqpProducer<T> {

    void producer(T t);
}
