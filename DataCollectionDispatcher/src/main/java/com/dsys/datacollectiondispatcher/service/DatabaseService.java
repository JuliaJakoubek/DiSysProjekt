package com.dsys.datacollectiondispatcher.service;



import java.sql.*;
import java.util.ArrayList;
import com.dsys.datacollectiondispatcher.model.Station;

public class DatabaseService {


    private static Connection connect() throws SQLException {
        String connectionString="jdbc:postgresql://localhost:30002/stationdb";
        return DriverManager.getConnection(connectionString, "postgres", "postgres");
    }



    public static ArrayList<Station> getStations() throws SQLException {
        ArrayList<Station> stations = new ArrayList<>();

        try ( Connection conn = connect() ) {
            String query = "SELECT id, db_url, lng, lat FROM station;";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            while( resultSet.next()) {
                Station station = new Station(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getFloat(3),
                        resultSet.getFloat(4)
                );
                stations.add(station);
            }
        }
        return stations;
    }
}
