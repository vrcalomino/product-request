package com.request.product.service;

import com.request.product.dto.RequestInformation;

public interface IRabbitMQSender {

    void send(RequestInformation requestInformation);
}
