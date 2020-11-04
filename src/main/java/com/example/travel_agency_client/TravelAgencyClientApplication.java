package com.example.travel_agency_client;

import com.example.travel_agency_client.Entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@SpringBootApplication
public class TravelAgencyClientApplication {

    private static final String URL = "http://localhost:8081";
    private static final HttpHeaders headers = new HttpHeaders();
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    public static void main(String[] args) {

        headers.setContentType(MediaType.APPLICATION_JSON);

        //create staff
        Instructor instructor_oleg = new Instructor("Oleg", "Petrov", 5);
        Instructor instructor_anna = new Instructor("Anna", "Malyna", 4);
        Instructor instructor_ivan = new Instructor("Ivan", "Sysanin", 3);
        Worker seller = new Worker("Mariia", "Sun", Position.SELLER);
        Worker manager = new Worker("Iryna", "Dudka", Position.MANAGER);

        addEntity("/instructor", instructor_anna);
        addEntity("/instructor", instructor_ivan);
        addEntity("/instructor", instructor_oleg);
        addEntity("/worker", seller);
        addEntity("/worker", manager);

        //create hike&vouchers
     //   Date date1 = new Date(2021-7-19);
        Hike carpathians = new Hike("Carpathians", "2021-07-19", 10, 3, 20, 15, 150, instructor_anna);
     //   Date date2 = new Date(2022-3-10);
        Hike alps = new Hike("Alps", "2022-03-10", 14, 5, 22, 10, 500, instructor_oleg);
     //   Date date3 = new Date(2022-6-14);
        Voucher bali = new Voucher("Bali", "2022-06-14",14, 85, 800);
     //   Date date4 = new Date(2021-9-1);
        Voucher italy = new Voucher("Italy", "2021-09-01", 7, 20, 550);

        addEntity("/hike", carpathians);
        addEntity("/hike", alps);
        addEntity("/voucher", bali);
        addEntity("/voucher", italy);

        //first 2 clients
        Client client_anna = new Client("Anna", "Vysh", 19, 0, true);
        Client client_mark = new Client("Mark", "Kruz", 33, 5, false);

        addEntity("/client", client_anna);
        addEntity("/client", client_mark);

        //clients`s orders
        Order order_anna = new Order(client_anna, seller).addHike(carpathians).addVoucher(bali);
        Order order_mark = new Order(client_mark, seller).addHike(alps).addVoucher(italy);

        addEntity("/order", order_anna);
        addEntity("/order", order_mark);
    }

    private static void addEntity(String path, Object entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String entityJson = objectMapper.writeValueAsString(entity);
            HttpEntity<String> entityJsonHttp = new HttpEntity<>(entityJson, headers);
            ResponseEntity<Void> response = restTemplate.postForEntity(URL +
                    path, entityJsonHttp, Void.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
