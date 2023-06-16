package com.dsys.datacollectiondispatcher;

import com.dsys.datacollectiondispatcher.service.DatabaseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class DataCollectionDispatcherApplication {

	public static void main(String[] args) {

		SpringApplication.run(DataCollectionDispatcherApplication.class, args);

	}

}
