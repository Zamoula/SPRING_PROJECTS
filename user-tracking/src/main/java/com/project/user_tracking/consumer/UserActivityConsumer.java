package com.project.user_tracking.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.user_tracking.model.UserActivityEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserActivityConsumer { //analytics logger
    @KafkaListener(topics = "user-activity", groupId = "user-activity-group")
    public void listen(UserActivityEvent event) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(event);
            System.out.println("Received User Activity:\n" + json);
            //System.out.println(event.getAction());
        } catch (JsonProcessingException e) {
            System.out.println("Received User Activity: " + event); // Fallback
        }
    }
}
