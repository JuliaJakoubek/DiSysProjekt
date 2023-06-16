package com.dsys.datacollectiondispatcher.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
public class Station {
    @Getter @Setter
    private int id;

    @Getter @Setter
    private String db_url;

    @Getter @Setter
    private float lat;

    @Getter @Setter
    private float lng;
}
