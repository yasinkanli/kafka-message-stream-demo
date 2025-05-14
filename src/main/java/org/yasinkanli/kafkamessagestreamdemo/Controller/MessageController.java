package org.yasinkanli.kafkamessagestreamdemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yasinkanli.kafkamessagestreamdemo.dto.UserMessageDto;
import org.yasinkanli.kafkamessagestreamdemo.service.KafkaProducerService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/send")
    public String sendMessage(@RequestBody UserMessageDto message) {
        producerService.sendMessage(message);
        return "Message sent: " + message.getContent();
    }
}