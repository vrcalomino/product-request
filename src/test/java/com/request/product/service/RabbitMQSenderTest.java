package com.request.product.service;

import com.request.product.model.RequestInformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@ExtendWith(MockitoExtension.class)
public class RabbitMQSenderTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private RabbitMQSender rabbitMQSender;

    @Test
    public void sendWithCorrectRequest() {
        RequestInformation requestInformation = new RequestInformation("email@mail.com", 2L);

        Mockito.doNothing()
                .when(rabbitTemplate)
                .convertAndSend(Mockito.anyString(), Mockito.any(RequestInformation.class));

        Assertions.assertDoesNotThrow(() -> rabbitMQSender.send(requestInformation));
    }

    @Test
    public void sendWithIncorrectRequest(){
        RequestInformation requestInformation = new RequestInformation();
        Assertions.assertThrows(Exception.class, () -> rabbitMQSender.send(requestInformation));
    }

    @Test
    public void sendWithoutRequest(){
        Assertions.assertThrows(Exception.class, () -> rabbitMQSender.send(null));
    }
}
