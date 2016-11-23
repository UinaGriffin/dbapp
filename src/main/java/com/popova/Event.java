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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (userId != event.userId) return false;
        if (eventType != event.eventType) return false;
        return !(timeStamp != null ? !timeStamp.equals(event.timeStamp) : event.timeStamp != null);

    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
