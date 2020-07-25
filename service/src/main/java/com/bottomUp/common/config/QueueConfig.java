package com.bottomUp.common.config;

/**
 * Created by raj on 7/25/2020.
 */
public enum QueueConfig {
    EMAIL_QUEUE("Echo.EmailQueue", "Queue for sending emails");


    private String queueName;
    private String queueDescription;

    QueueConfig(String queueName, String queueDescription) {
        this.queueName = queueName;
        this.queueDescription = queueDescription;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getQueueDescription() {
        return queueDescription;
    }

    public void setQueueDescription(String queueDescription) {
        this.queueDescription = queueDescription;
    }
}
