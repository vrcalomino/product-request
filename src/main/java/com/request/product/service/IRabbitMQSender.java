package com.request.product.service;

import com.request.product.model.RequestInformation;

public interface IRabbitMQSender {

    void send(RequestInformation requestInformation);
}
