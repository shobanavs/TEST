package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import java.util.Objects;


@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }

//    @Bean
//    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
//        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
//        servlet.setApplicationContext(applicationContext);
//        servlet.setTransformWsdlLocations(true);
//
//        // Register servlet and specify the path to the XML file in src/main/resources
//        ServletRegistrationBean<MessageDispatcherServlet> bean =
//                new ServletRegistrationBean<>(servlet, "/ws/*");
//        bean.addInitParameter("contextConfigLocation", "classpath:/messageDispatcherServlet-servlet.xml");
//        return bean;
//    }
}
