package com.request.product.service;

import com.request.product.config.RabbitMQConfig;
import com.request.product.model.RequestInformation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender implements IRabbitMQSender{

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;;
    }

    public void send(RequestInformation requestInformation) throws Exception {
        if (requestInformation == null || requestInformation.getEmail() == null || requestInformation.getProduct_id() == null) {
            throw new Exception("Missing or incorrect request information");
        }
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, requestInformation);
    }
}
