package com.example.travel_agency_client.GrpcMethods;

import com.example.hike.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HikeMethods {

    public HikeResponse addHike(String name, String date, int dur, int comp, int age,
                                int people, double price, String instructor){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        HikeServiceGrpc.HikeServiceBlockingStub stub = HikeServiceGrpc.newBlockingStub(channel);

        HikeResponse response = stub.add(HikeRequest.newBuilder()
                .setName(name)
                .setDate(date)
                .setDuration(dur)
                .setComplexity(comp)
                .setMinAge(age)
                .setMaxPeople(people)
                .setPrice(price)
                .setInstructorId(instructor)
                .build());
        channel.shutdown();
        return response;
    }

    public AllHikesResponse getAllHikes(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        HikeServiceGrpc.HikeServiceBlockingStub stub = HikeServiceGrpc.newBlockingStub(channel);

        AllHikesResponse responses = stub.all(AllHikesRequest.newBuilder().build());
        channel.shutdown();
        return responses;
    }

    public HikeResponse getHikeById(String id){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        HikeServiceGrpc.HikeServiceBlockingStub stub = HikeServiceGrpc.newBlockingStub(channel);

        HikeResponse response = stub.byId(HikeByIdRequest.newBuilder().setId(id).build());
        channel.shutdown();
        return response;
    }

    public DeleteHikeResponse deleteHike(String id){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        HikeServiceGrpc.HikeServiceBlockingStub stub = HikeServiceGrpc.newBlockingStub(channel);

        DeleteHikeResponse response = stub.delete(HikeByIdRequest.newBuilder().setId(id).build());
        channel.shutdown();
        return response;
    }
}

