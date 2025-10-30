package com.bcf.sqs.infraestructure.inrest;

import com.bcf.sqs.domain.model.Message;
import com.bcf.sqs.domain.service.SqsSenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sqs")
public class SqsController {

    private final SqsSenderService sqsSenderService;

    public SqsController(SqsSenderService sqsSenderService) {
        this.sqsSenderService = sqsSenderService;
    }


    @PostMapping(path = "/send")
    public String sendMessage(@RequestBody Message message) throws JsonProcessingException {
        sqsSenderService.sendMessage(message);
        return "Mensaje enviado!";
    }
}
