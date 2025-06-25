package com.project.user_tracking.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserActivityEvent {
    private String userId;
    private String pageUrl;
    private String action; // "CLICK", "VIEW"...
    private long timestamp;

    @Override
    public String toString() {
        return "UserActivityEvent{" +
                "action='" + action + '\'' +
                ", userId='" + userId + '\'' +
                ", pageUrl='" + pageUrl + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
