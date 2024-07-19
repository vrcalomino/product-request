package com.request.product.service;

import com.request.product.config.RabbitMQConfig;
import com.request.product.dto.RequestInformation;
import com.request.product.model.ProductRequest;
import com.request.product.repository.ProductRequestRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender implements IRabbitMQSender{

    private final ProductRequestRepository repository;
    private final RabbitTemplate rabbitTemplate;

    public RabbitMQSender(ProductRequestRepository repository, RabbitTemplate rabbitTemplate) {
        this.repository = repository;
        this.rabbitTemplate = rabbitTemplate;;
    }

    public void send(RequestInformation requestInformation) {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProduct_id(requestInformation.getProduct_id());
        productRequest.setMail(requestInformation.getEmail());
        productRequest = repository.save(productRequest);
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, productRequest);
    }
}
