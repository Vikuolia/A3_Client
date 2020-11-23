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

@SpringBootApplication
public class TravelAgencyClientApplication {

    private static final String URL = "http://192.168.104.231:31795";
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

        //create hikes
        Hike carpathians = new Hike("Carpathians", "2021-07-19", 10, 3, 20, 15,
                150, instructor_anna.getId());
        Hike alps = new Hike("Alps", "2022-03-10", 14, 5, 22, 10,
                500, instructor_oleg.getId());

        addEntity("/hike", carpathians);
        addEntity("/hike", alps);

        //first 2 clients
        Client client_anna = new Client("Anna", "Vysh", 19, 0, true);
        Client client_mark = new Client("Mark", "Kruz", 33, 5, false);

        addEntity("/client", client_anna);
        addEntity("/client", client_mark);

        //clients`s orders
        Order order_anna = new Order(client_anna.getId(), seller.getId(), alps.getId());
        Order order_mark = new Order(client_mark.getId(), seller.getId(), carpathians.getId());

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
