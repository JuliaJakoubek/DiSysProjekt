package com.dsys.datacollectiondispatcher.controller;

import com.dsys.datacollectiondispatcher.model.Station;
import com.dsys.datacollectiondispatcher.service.DatabaseService;
import com.dsys.datacollectiondispatcher.service.MessageService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class DistpatchingController {

    private static MessageService messageService = new MessageService();
    private static DatabaseService databaseService = new DatabaseService();
    public void run() throws IOException, TimeoutException {
            String[] subscribedTo=new String[1];
            subscribedTo[0] = "customer_id";
            messageService.listen(subscribedTo);
    }
    public static void dispatch(int customerId) throws Exception {
        ArrayList<Station> stations = databaseService.getStations();
        messageService.sendMessage("collection_receiver", ""+customerId, ""+customerId);
        stations.forEach(station -> {
            try {
                messageService.sendMessage("data_collector", station.getDb_url() + " " + customerId, ""+customerId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
