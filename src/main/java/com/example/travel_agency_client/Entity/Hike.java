package com.example.travel_agency_client.Entity;

import lombok.Data;
import java.util.UUID;

@Data
public class Hike {

    private String hikeId;

    private String name;
    private String date;
    private int duration;
    private int complexity; //0-6
    private int min_age;
    private int  max_people;
    private double price;

    private String instructorId;

    public Hike(String name, String date, int duration, int complexity, int min_age, int max_people,
                double price, String instructorId){
        this.hikeId = UUID.randomUUID().toString();
        this.name = name;
        this.date = date;
        this.duration = duration;
        this.complexity = complexity;
        this.min_age = min_age;
        this.max_people = max_people;
        this.price = price;
        this.instructorId = instructorId;
    }

    public String getId(){
        return this.hikeId;
    }

}

