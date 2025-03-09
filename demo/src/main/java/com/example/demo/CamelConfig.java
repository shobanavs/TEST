package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("spring-ws://http://localhost:8081/services/HelloSoapService")
            .routeId("soapRoute")
            .log("Received SOAP request")
            .bean(HelloSoapEndpoint.class, "handleHelloSoapRequest");
    }
}
