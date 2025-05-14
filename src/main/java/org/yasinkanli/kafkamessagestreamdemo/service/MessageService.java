package org.yasinkanli.kafkamessagestreamdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yasinkanli.kafkamessagestreamdemo.dto.UserMessageDto;
import org.yasinkanli.kafkamessagestreamdemo.entity.MessageEntity;
import org.yasinkanli.kafkamessagestreamdemo.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public void saveMessage(UserMessageDto userMessage) {
        MessageEntity entity = new MessageEntity();
        entity.setSender(userMessage.getSender());
        entity.setContent(userMessage.getContent());
        repository.save(entity);
    }
}