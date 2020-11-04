package com.example.travel_agency_client.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
public class Voucher {

    private String voucherId;

    private String name;
    private String date;
    private int duration;
    private int max_people;
    private double price;

    List<Order> orders = new ArrayList<>();

    public Voucher(String name, String date, int duration, int max_people, int price){
        this.voucherId = UUID.randomUUID().toString();
        this.date = date;
        this.duration = duration;
        this.max_people = max_people;
        this.price = price;
    }

    public double getPrice(){return this.price;}

    public int getMax_people(){return this.max_people;}

    public String getName(){return this.name;}
}

