package config.redis;

import entity.redis.MessageLetter;

public interface MessageService {

    void addMessageLetter(MessageLetter messageLetter);
}
