package com.example.demo;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

// Response POJO
@XmlRootElement(namespace = "http://www.flydubai.com/HelloSoap")
public class HelloSoapResponse {

    private String response;
    @XmlElement(namespace = "http://www.flydubai.com/HelloSoap")
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
