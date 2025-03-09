package com.example;

import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;

@GrpcService
public class HelloGrpcServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    private final SoapClient soapClient;

    public HelloGrpcServiceImpl() {
        this.soapClient = new SoapClient();
    }

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String name = request.getClientName();
        String soapResponse = null;
        try {
            soapResponse = soapClient.callSoapService(request.getClientName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        responseObserver.onNext(HelloResponse.newBuilder().setMessage(soapResponse).build());
        responseObserver.onCompleted();
    }

}



