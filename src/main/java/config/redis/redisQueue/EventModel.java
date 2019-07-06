package config.redis.redisQueue;

import entity.redis.EventType;

import java.util.HashMap;
import java.util.Map;

public class EventModel {

    private EventType eventType;

    //事件触发者
    private String triggerId;

    //事件受影响者
    private String receiverId;

    //额外信息
    private Map<String, String> extraInfo = new HashMap<String, String>();

    public EventModel(EventType eventType) {
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getTriggerId() {
        return triggerId;
    }

    public void setTriggerId(String triggerId) {
        this.triggerId = triggerId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public Map<String, String> getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(Map<String, String> extraInfo) {
        this.extraInfo = extraInfo;
    }
}
