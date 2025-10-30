package com.bcf.sqs.domain.service;

import com.bcf.sqs.domain.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import java.time.LocalDateTime;

/**
 * 1.Enviar Mensajes a SQS
 * - servicio para [ENVIAR] mensajes a la cola
 */
@Service
public class SqsSenderService {
    //[SqsConfig.java]: creacion de instancia
    private final SqsAsyncClient sqsAsyncClient;
    private final String queueUrl;
    private final ObjectMapper objectMapper;

    public SqsSenderService(
            SqsAsyncClient sqsAsyncClient,
            @Value("${aws.sqs.queue-url}") String queueUrl, ObjectMapper objectMapper) {
        this.sqsAsyncClient = sqsAsyncClient;
        this.queueUrl = queueUrl;
        this.objectMapper = objectMapper;
    }


    public void sendMessage(Message message) throws JsonProcessingException {
        // /////////////////////////////////////////////////////////////
        //nueva logica o envio un adaptador de base datos u otro .. etc
        message.setCreatedAt(LocalDateTime.now());
        // /////////////////////////////////////////////////////////////

        String jsonMessage = objectMapper.writeValueAsString(message);

        SendMessageRequest request = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(jsonMessage)
                .build();

        //->envía un mensaje a la cola. [[SqsConsumer.java].receiveMessage()]
        sqsAsyncClient.sendMessage(request);
    }
}
