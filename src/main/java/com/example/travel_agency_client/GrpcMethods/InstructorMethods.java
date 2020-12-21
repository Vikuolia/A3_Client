package com.example.travel_agency_client.GrpcMethods;

import com.example.instructor.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class InstructorMethods {

    public static String addInstructor(String name, String surname, int back){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        InstructorServiceGrpc.InstructorServiceBlockingStub stub = InstructorServiceGrpc.newBlockingStub(channel);

        InstructorResponse response = stub.add(InstructorRequest.newBuilder()
                .setName(name)
                .setSurname(surname)
                .setBackground(back)
                .build());
        channel.shutdown();
        return "\n* Instructor *\nid: "+response.getId()+"\nname: "+response.getName()+"\nsurname: "+response.getSurname()
                +"\nbackground: "+response.getBackground()+"\n* was added *";
    }

    public static AllInstructorsResponse getAllInstructors(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        InstructorServiceGrpc.InstructorServiceBlockingStub stub = InstructorServiceGrpc.newBlockingStub(channel);

        AllInstructorsResponse responses = stub.all(AllInstructorsRequest.newBuilder().build());
        channel.shutdown();
        return responses;
    }

    public static InstructorResponse getInstructorById(String id){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        InstructorServiceGrpc.InstructorServiceBlockingStub stub = InstructorServiceGrpc.newBlockingStub(channel);

        InstructorResponse response = stub.byId(InstructorByIdRequest.newBuilder().setId(id).build());
        channel.shutdown();
        return response;
    }

    public static DeleteInstructorResponse deleteInstructor(String id){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        InstructorServiceGrpc.InstructorServiceBlockingStub stub = InstructorServiceGrpc.newBlockingStub(channel);

        DeleteInstructorResponse response = stub.delete(InstructorByIdRequest.newBuilder().setId(id).build());
        channel.shutdown();
        return response;
    }
}

