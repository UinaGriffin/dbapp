package com.popova;

import com.sun.corba.se.spi.activation.Repository;

import java.util.Date;

public class Runner {

    public static void main(String[] args) {
        EventRepository repository = new EventRepositoryImpl();
        Event event = getEvent();
        repository.saveEvent(event);
    }

    private static Event getEvent() {
        Event event = new Event();
        event.setEventType(Event.EventType.ACTIVITY);
        event.setUserId(1);
        event.setTimeStamp(new Date());
        return event;
    }
}
