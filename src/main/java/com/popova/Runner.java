package com.popova;

public class Runner {

    public static void main(String[] args) {
        EventRepository repository = new EventRepositoryImpl();
        EventService eventService = new EventServiceImpl(repository);
        eventService.generateFakeDataSet();

    }

}
