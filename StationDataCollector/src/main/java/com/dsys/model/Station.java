package com.dsys.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
public class Station {
    @Getter @Setter
    private int id;

    @Getter @Setter
    private float kwh;

    @Getter @Setter
    private int customer_id;

}
