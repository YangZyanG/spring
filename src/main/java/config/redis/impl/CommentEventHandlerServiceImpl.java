package config.redis.impl;

import config.redis.EventHandlerService;
import config.redis.MessageService;
import config.redis.redisQueue.EventModel;
import entity.redis.EventType;
import entity.redis.MessageLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentEventHandlerServiceImpl implements EventHandlerService {

    @Autowired
    private MessageService messageService;

    public void doHandle(EventModel eventModel) {

        MessageLetter letter = new MessageLetter();
        letter.setFromUserId(eventModel.getTriggerId());
        letter.setToUserId(eventModel.getReceiverId());

        if(eventModel.getEventType() == EventType.COMMENT){
            letter.setLetter("用户" + eventModel.getTriggerId() + "在你文章" + eventModel.getExtraInfo().get("articleName") +
                    "评论中说到：" + eventModel.getExtraInfo().get("comment"));
        }

        messageService.addMessageLetter(letter);
    }

    public EventType getEventType(){
        return EventType.COMMENT;
    }
}
