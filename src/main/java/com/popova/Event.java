package com.popova;

import java.util.Date;

public class Event {
    public enum EventType {
        ACTIVITY, IMPRESSION
    }

    private int userId;
    private EventType eventType;
    private Date timeStamp;

    public Event() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
