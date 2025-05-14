package org.yasinkanli.kafkamessagestreamdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.yasinkanli.kafkamessagestreamdemo.dto.UserMessageDto;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "demo-topic";

    @Autowired
    private KafkaTemplate<String, UserMessageDto> kafkaTemplate;

    public void sendMessage(UserMessageDto message) {
        kafkaTemplate.send(TOPIC, message);
    }
}