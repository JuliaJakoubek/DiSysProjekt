package com.dsys.controller;

import com.dsys.model.Station;
import com.dsys.service.DatabaseService;
import com.dsys.service.MessageService;

import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class CollectionController {
    private static DatabaseService databaseService = new DatabaseService();
    private static MessageService messageService = new MessageService();
    public static void run() throws IOException, TimeoutException {
        String[] subscribe = new String[2];
        subscribe[0] = "data_collector";
        messageService.listen(subscribe);
    }
    public static void collect(int customer_id ,String url) throws SQLException {
        ArrayList<Station> stations =  databaseService.getStations(customer_id, url);
        stations.forEach(station -> {
            try {
                messageService.sendMessage("collection_receiver", station.getKwh() + " " +customer_id, ""+customer_id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    };
}
