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

    private Client client;

    private Worker seller;

    List<Hike> hikes = new ArrayList<>();

    List<Voucher> vouchers = new ArrayList<>();

    public Order(Client client, Worker seller){
        this.orderId = UUID.randomUUID().toString();
        this.client = client;
        this.seller = seller;
        this.date = new Date().toString();
        this.price = 0;
        this.status = Status.inProgress;
    }

    public void updateStatus(Status newStatus){
        this.status = newStatus;
    }

    public Order addHike(Hike hike){
        hikes.add(hike);
        return this;
    }

    public Order addVoucher(Voucher voucher){
        vouchers.add(voucher);
        return this;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public List<Hike> getHikes(){return hikes;}

    public List<Voucher> getVouchers(){return vouchers;}

    public Client getClient(){return this.client;}
}

