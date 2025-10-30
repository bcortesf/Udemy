package com.bcf.sqs.service;


import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.bcf.sqs.domain.models.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * Productores :
 *   Son los componentes que envían mensajes a la cola.
 *   Por ejemplo, una aplicación web podría enviar una solicitud de procesamiento a la cola.
 */
@Service
@Log4j2
public class Publisher {
    @Value(value = "${aws.queueName}")
    private String queueName;

    //bean[AmazonSQS], instanciado en "SqsConfig.java"
    private final AmazonSQS amazonSQSClient;
    private final ObjectMapper objectMapper;

    public Publisher(AmazonSQS amazonSQSClient, ObjectMapper objectMapper) {
        this.amazonSQSClient = amazonSQSClient;
        this.objectMapper = objectMapper;
    }


    public void publishMessage(String id) {
        try {
            GetQueueUrlResult queueUrl = amazonSQSClient.getQueueUrl(queueName);

            //[Message.java]
            /*var   message = ... */
            Message message = Message.builder()
                    .id(id)
                    .content("message")
                    .createdAt( LocalDateTime.now().toString() )
                    .build();

            //SendMessageResult result = amazonSQSClient.sendMessage( queueUrl.getQueueUrl(), objectMapper.writeValueAsString(message)
            /* amazonSQSClient.sendMessage():
             *  - This line sends the created message to the SQS queue.
             */
            amazonSQSClient.sendMessage(
                    queueUrl.getQueueUrl(),
                    objectMapper.writeValueAsString(message)
            );
        } catch (Exception e) {
            log.error("Queue Exeption Message: {}", e.getMessage());
        }
    }
}
