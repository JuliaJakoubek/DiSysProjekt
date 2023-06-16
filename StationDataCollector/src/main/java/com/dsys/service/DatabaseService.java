package com.dsys.service;



import com.dsys.model.Station;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseService {


    private static Connection connect(String to) throws SQLException {
        String connectionString="jdbc:postgresql://" + to;
        return DriverManager.getConnection(connectionString, "postgres", "postgres");
    }



    public static ArrayList<Station> getStations(int customer_id, String to) throws SQLException {
        ArrayList<Station> stations = new ArrayList<>();

        try ( Connection conn = connect(to) ) {
            String query = "SELECT id, kwh, customer_id FROM station WHERE customer_id = " + customer_id +";";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            while( resultSet.next()) {
                Station station = new Station(
                        resultSet.getInt(1),
                        resultSet.getFloat(2),
                        resultSet.getInt(3)
                );
                stations.add(station);
            }
        }
        return stations;
    }
}
