package com.project.user_tracking.controller;

import com.project.user_tracking.model.UserActivityEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserActivityController { //website simulator

    private final KafkaTemplate<String, UserActivityEvent> kafkaTemplate;

    public UserActivityController(KafkaTemplate<String, UserActivityEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/track")
    public String trackActivity(@RequestBody UserActivityEvent event) {
        event.setTimestamp(System.currentTimeMillis());
        kafkaTemplate.send("user-activity", event.getUserId(), event);
        return "Activity tracked!";
    }
}
