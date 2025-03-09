package com.example.demo;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloSoapEndpoint {

    private static final String NAMESPACE_URI = "http://www.flydubai.com/HelloSoap";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "helloSoapRequest")
    @ResponsePayload
    public HelloSoapResponse handleHelloSoapRequest(@RequestPayload HelloSoapRequest request) {
        HelloSoapResponse response = new HelloSoapResponse();
        response.setResponse("Welcome " + request.getClientName());
        return response;
    }
}
