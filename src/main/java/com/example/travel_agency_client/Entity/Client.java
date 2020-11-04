package com.example.travel_agency_client.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Data
public class Client {

    private String clientId;

    private String name;
    private String surname;
    private int age;
    private int background;
    private boolean student;
    private boolean frequentBuyer;

    List<Order> orders = new ArrayList<>();

    public Client(String name, String surname, int age, int background, boolean student){
        this.clientId = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.background = background;
        this.student = student;
        this.frequentBuyer = false;
    }

    public int getAge(){return this.age;}

    public int getBackground(){return this.background;}

    public boolean isStudent(){return this.student;}

    public boolean isFrequentBuyer(){return this.frequentBuyer;}

    public void makeFrequentBuyer(){this.frequentBuyer = true;}

    @Override
    public String toString(){
        return "\n-CLIENT-\nName: " + this.name + "\nSurname: " + this.surname + "\nAge: " +
                this.age + "\nBackground: " + this.background + "\nStudent: " + this.student +
                "\nFrequent buyer: " + this.frequentBuyer;
    }
}
