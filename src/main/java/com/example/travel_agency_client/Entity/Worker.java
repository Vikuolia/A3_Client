package com.example.travel_agency_client.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
public class Worker {

    private String workerId;

    private String name;
    private String surname;
    private Position position;

    public Worker(String name, String surname, Position position){
        this.workerId = UUID.randomUUID().toString();
        this.surname = surname;
        this.name = name;
        this.position = position;
    }

    public String getId(){
        return this.workerId;
    }
}

