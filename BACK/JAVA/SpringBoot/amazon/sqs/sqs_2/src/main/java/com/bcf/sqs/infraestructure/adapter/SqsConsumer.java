package com.bcf.sqs.infraestructure.adapter;

import com.bcf.sqs.domain.model.Message;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * 2. Recibir Mensajes de SQS (Listener)
 * - recibir mensajes automáticamente mediante un [LISTENER], con Spring Cloud AWS
 */
@Component
@Log4j2
public class SqsConsumer {

    @SqsListener("spring-aws-queue") //"mi-cola"
    public void receiveMessage(Message message) {
       log.info("Mensaje recibido {}", message);
    }
}
