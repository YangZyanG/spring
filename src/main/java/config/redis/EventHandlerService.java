package config.redis;

import config.redis.redisQueue.EventModel;
import entity.redis.EventType;

public interface EventHandlerService {

    void doHandle(EventModel eventModel);

    EventType getEventType();
}
