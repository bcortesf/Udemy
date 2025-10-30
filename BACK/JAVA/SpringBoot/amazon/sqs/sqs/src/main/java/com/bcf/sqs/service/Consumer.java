package com.bcf.sqs.service;


import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Consumidores  :
 *   Son los componentes que recuperan y procesan los mensajes de la cola.
 *   Pueden ser trabajadores, microservicios o cualquier otro sistema que necesite manejar las tareas.
 */
@Service
@Log4j2
public class Consumer {
    @Value(value = "${aws.queueName}")
    private String queueName;

    //bean[AmazonSQS], instanciado en "SqsConfig.java"
    private final AmazonSQS amazonSQSClient;

    public Consumer(AmazonSQS amazonSQSClient) {
        this.amazonSQSClient = amazonSQSClient;
    }


    /**
     * consumeMessages(): The method runs every 5 seconds. Polls queue messages and deletes read message.
     */
    @Scheduled(fixedDelay = 5000) //It runs every 5 seconds
    public void  consumeMessages() {
        try {
            String queueUrl = amazonSQSClient.getQueueUrl(queueName).getQueueUrl();
            ReceiveMessageResult receiveMessageResult = amazonSQSClient.receiveMessage(queueUrl);

            //amazon-sqs:  si tiene un mensaje en la cola, entonces procesar
            if (!receiveMessageResult.getMessages().isEmpty()) {
                //[com.amazonaws.services.sqs.model.Message]: primer mensaje que entro en la cola de amazon
                Message message = receiveMessageResult.getMessages().get(0);

                log.info("Read Message from queue: {}", message.getBody()); //contenido mensaje
                amazonSQSClient.deleteMessage(queueUrl, message.getReceiptHandle()); //identificador asociado al mensaje eliminado de la cola
            }
        } catch (Exception e) {
            log.error("Queue Exception Message: {}", e.getMessage());
        }
    }
}
