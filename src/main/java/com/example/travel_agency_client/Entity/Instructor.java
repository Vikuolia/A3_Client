package com.example.travel_agency_client.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public final class Instructor{

    private String instructorId;

    private String name;
    private String surname;
    private int background;

    private List<Hike> hikes = new ArrayList<>();

    public Instructor(String name, String surname, int background){
        this.instructorId = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.background = background;
    }
}
