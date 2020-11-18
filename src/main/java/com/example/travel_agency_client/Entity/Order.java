package com.example.travel_agency_client.Entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class Order {

    private String orderId;
    private String date;
    private double price;
    private Status status;

    private String clientId;

    private String sellerId;

    private String idHike;

    public Order(String clientId, String sellerId, String idHike){
        this.orderId = UUID.randomUUID().toString();
        this.clientId = clientId;
        this.sellerId = sellerId;
        this.date = new Date().toString();
        this.price = 0;
        this.status = Status.inProgress;
    }

    public void updateStatus(Status newStatus){
        this.status = newStatus;
    }


    public void setPrice(double newPrice){
        this.price = newPrice;
    }
}

