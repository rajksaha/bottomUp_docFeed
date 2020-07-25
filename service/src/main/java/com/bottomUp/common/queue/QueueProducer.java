package com.bottomUp.common.queue;

import com.bottomUp.common.config.QueueConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;

/**
 * Created by raj on 7/25/2020.
 */
public class QueueProducer {

    private static final Logger log = LoggerFactory.getLogger(QueueProducer.class);

    private AmqpAdmin amqpAdmin;
    private AmqpTemplate amqpTemplate;

    public QueueProducer(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
    }

    public void sendObject(QueueConfig queueConfig, Object queueObject) {
        log.debug("Sending message : " + queueObject + " to queue : " + queueConfig.getQueueName());
        amqpTemplate.convertAndSend(queueConfig.getQueueName(), queueObject);
    }
}
