package com.request.product.controller;

import com.request.product.model.RequestInformation;
import com.request.product.service.IRabbitMQSender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class RequestController {

    private final IRabbitMQSender rabbitMQSender;

    public RequestController(IRabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    @PostMapping("/request")
    public ResponseEntity<String> sendProductRequest(@RequestBody RequestInformation requestInformation) {
        rabbitMQSender.send(requestInformation);
        return new ResponseEntity<>("Request sent!", HttpStatus.OK);
    }
}
