package config.redis;

import config.redis.redisQueue.EventModel;

public interface EventHandlerService {

    void doHandle(EventModel eventModel);
}
