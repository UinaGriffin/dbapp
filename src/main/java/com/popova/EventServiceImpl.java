package com.popova;

import java.util.*;

public class EventServiceImpl implements EventService {
    public static final int NUMBER_OF_FAKE_EVENTS = 50;

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public void generateFakeDataSet() {
        Set<Event> events = generateFakeEvents();
        saveEvents(events);
    }

    private Set<Event> generateFakeEvents() {
        Set<Event> events = new HashSet<Event>();
        for (int i = 0; i < NUMBER_OF_FAKE_EVENTS; i++) {
            Event event = generateFakeEvent();
            events.add(event);
        }
        return events;
    }

    private Event generateFakeEvent() {

        Random rand = new Random();
        int userId = rand.nextInt(998) + 1;


        Event.EventType[] values = Event.EventType.values();
        int eventTypeIndex=rand.nextInt(values.length);
        Event.EventType eventType = values[eventTypeIndex];

        long fakeDateLong = new Date().getTime()-userId;
        Date fakeDate = new Date(fakeDateLong);


        Event fakeEvent = new Event();
        fakeEvent.setUserId(userId);
        fakeEvent.setEventType(eventType);
        fakeEvent.setTimeStamp(fakeDate);

        return fakeEvent;
    }

    private void saveEvents(Set<Event> events) {
        for (Event event : events) {
            eventRepository.saveEvent(event);
        }
    }
}
