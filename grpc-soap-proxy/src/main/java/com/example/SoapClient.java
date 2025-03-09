package com.example;


import jakarta.xml.soap.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class SoapClient {
    public String callSoapService(String clientName) throws Exception {
        // SOAP endpoint
        String soapEndpoint = "http://localhost:8081/services/HelloSoapService";
        String soapAction = "http://www.flydubai.com/HelloSoap/helloSoapRequest";
        
        // Create SOAP request message
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("web", "http://www.flydubai.com/HelloSoap");

        // Create the body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapElement = soapBody.addChildElement("helloSoapRequest", "web");
        SOAPElement clientNameElement = soapElement.addChildElement("clientName", "web");
        clientNameElement.addTextNode(clientName);

        soapMessage.saveChanges();
        
        // Send the request and get the response
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        SOAPMessage response = soapConnection.call(soapMessage, soapEndpoint);

        // Extract response
        SOAPBody responseBody = response.getSOAPBody();

        // Extract the root element (helloSoapResponse)
        SOAPElement helloSoapResponse = (SOAPElement) responseBody.getChildElements().next();

        // Extract the nested element (response)
        SOAPElement responseElement = (SOAPElement) helloSoapResponse.getChildElements().next();

        // Get the text content of the response element
        String responseText = responseElement.getValue();

        // Print the extracted value
        System.out.println("Extracted Response: " + responseText);

        soapConnection.close();
        
        return responseText;
    }


}
