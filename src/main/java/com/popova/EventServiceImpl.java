package com.popova;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class EventServiceImpl implements EventService {
    public static final int NUMBER_OF_FAKE_EVENTS = 50;

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public void generateFakeDataSet() {
        List<Event> events = generateFakeEvents();
        saveEvents(events);
    }

    private List<Event> generateFakeEvents() {
        List<Event> events = new ArrayList<Event>();
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

        Date fakeDate = new Date();


        Event fakeEvent = new Event();
        fakeEvent.setUserId(userId);
        fakeEvent.setEventType(eventType);
        fakeEvent.setTimeStamp(fakeDate);

        return fakeEvent;
    }

    private void saveEvents(List<Event> events) {
        for (Event event : events) {
            eventRepository.saveEvent(event);
        }
    }
}
