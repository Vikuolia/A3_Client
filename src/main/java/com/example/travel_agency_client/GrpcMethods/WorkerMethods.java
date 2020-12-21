package com.example.travel_agency_client.GrpcMethods;

import com.example.worker.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class WorkerMethods {

    public static WorkerResponse addWorker(String name, String surname, Position position){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        WorkerServiceGrpc.WorkerServiceBlockingStub stub = WorkerServiceGrpc.newBlockingStub(channel);

        WorkerResponse response = stub.add(WorkerRequest.newBuilder()
                .setName(name)
                .setSurname(surname)
                .setPosition(position)
                .build());
        channel.shutdown();
        return response;
    }

    public AllWorkersResponse getAllWorkers(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        WorkerServiceGrpc.WorkerServiceBlockingStub stub = WorkerServiceGrpc.newBlockingStub(channel);

        AllWorkersResponse responses = stub.all(AllWorkersRequest.newBuilder().build());
        channel.shutdown();
        return responses;
    }

    public WorkerResponse getWorkerById(String id){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        WorkerServiceGrpc.WorkerServiceBlockingStub stub = WorkerServiceGrpc.newBlockingStub(channel);

        WorkerResponse response = stub.byId(WorkerByIdRequest.newBuilder().setId(id).build());
        channel.shutdown();
        return response;
    }

    public static DeleteWorkerResponse deleteWorker(String id){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        WorkerServiceGrpc.WorkerServiceBlockingStub stub = WorkerServiceGrpc.newBlockingStub(channel);

        DeleteWorkerResponse response = stub.delete(WorkerByIdRequest.newBuilder().setId(id).build());
        channel.shutdown();
        return response;
    }
}


