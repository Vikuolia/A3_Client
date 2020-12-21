package com.example.travel_agency_client.GrpcMethods;

import com.example.instructor.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientMethods {

    public ClientResponse addClient(String name, String surname, int age, int back, boolean student){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        ClientServiceGrpc.ClientServiceBlockingStub stub = ClientServiceGrpc.newBlockingStub(channel);

        ClientResponse response = stub.add(ClientRequest.newBuilder()
                .setName(name)
                .setSurname(surname)
                .setAge(age)
                .setBackground(back)
                .setStudent(student)
                .build());
        channel.shutdown();
        return response;
    }

    public AllClientsResponse getAllClients(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        ClientServiceGrpc.ClientServiceBlockingStub stub = ClientServiceGrpc.newBlockingStub(channel);

        AllClientsResponse responses = stub.all(AllClientsRequest.newBuilder().build());
        channel.shutdown();
        return responses;
    }

    public ClientResponse getClientById(String id){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        ClientServiceGrpc.ClientServiceBlockingStub stub = ClientServiceGrpc.newBlockingStub(channel);

        ClientResponse response = stub.byId(ClientByIdRequest.newBuilder().setId(id).build());
        channel.shutdown();
        return response;
    }

    public DeleteClientResponse deleteClient(String id){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        ClientServiceGrpc.ClientServiceBlockingStub stub = ClientServiceGrpc.newBlockingStub(channel);

        DeleteClientResponse response = stub.delete(ClientByIdRequest.newBuilder().setId(id).build());
        channel.shutdown();
        return response;
    }
}

