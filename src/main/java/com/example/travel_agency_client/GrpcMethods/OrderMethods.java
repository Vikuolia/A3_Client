package com.example.travel_agency_client.GrpcMethods;

import com.example.order.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class OrderMethods {

    public OrderResponse addOrder(String client, String seller, String hike){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);

        OrderResponse response = stub.add(OrderRequest.newBuilder()
                .setClient(client)
                .setSeller(seller)
                .setHike(hike)
                .build());
        channel.shutdown();
        return response;
    }

    public AllOrdersResponse getAllOrder(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);

        AllOrdersResponse responses = stub.all(AllOrdersRequest.newBuilder().build());
        channel.shutdown();
        return responses;
    }

    public OrderResponse getOrderById(String id){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);

        OrderResponse response = stub.byId(OrderByIdRequest.newBuilder().setId(id).build());
        channel.shutdown();
        return response;
    }

    public DeleteOrderResponse deleteHike(String id){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7087).usePlaintext().build();
        OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);

        DeleteOrderResponse response = stub.delete(OrderByIdRequest.newBuilder().setId(id).build());
        channel.shutdown();
        return response;
    }
}


