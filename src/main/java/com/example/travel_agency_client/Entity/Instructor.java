package com.example.travel_agency_client.Entity;

import lombok.Data;

import java.util.UUID;

@Data
public final class Instructor{

    private String instructorId;

    private String name;
    private String surname;
    private int background;

    public Instructor(String name, String surname, int background){
        this.instructorId = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.background = background;
    }

    public String getId(){
        return this.instructorId;
    }
}
