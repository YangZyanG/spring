package config.redis.impl;

import config.redis.MessageService;
import entity.redis.MessageLetter;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageLetter messageLetter;

    public void addMessageLetter(MessageLetter messageLetter) {
        this.messageLetter = messageLetter;
    }
}
