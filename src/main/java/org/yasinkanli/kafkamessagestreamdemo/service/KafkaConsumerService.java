package org.yasinkanli.kafkamessagestreamdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.yasinkanli.kafkamessagestreamdemo.dto.UserMessageDto;

@Service
public class KafkaConsumerService {

    @Autowired
    private MessageService messageService;

    @KafkaListener(topics = "demo-topic", groupId = "demo-group", containerFactory = "userMessageListenerContainerFactory")
    public void consume(UserMessageDto userMessage) {
        System.out.println("Consumed message: " + userMessage.getContent());
        messageService.saveMessage(userMessage);
    }
}