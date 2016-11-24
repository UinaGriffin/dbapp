package com.popova;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        DatabaseCommandExecutor databaseCommandExecutor = new DatabaseCommandExecutor();
        EventRepository repository = new EventRepositoryImpl(databaseCommandExecutor);
        RegionRepositoryImpl regionRepository = new RegionRepositoryImpl(databaseCommandExecutor);
        EventService eventService = new EventServiceImpl(repository);
//        eventService.generateFakeDataSet();
        List<Integer> allRegionIds = regionRepository.findAllRegionIds();
        System.out.println(allRegionIds);
    }

}
