package com.redhat;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.amqp.AMQPComponent;

public class receiveRoute extends RouteBuilder{

    AMQPComponent authorizedAmqp = AMQPComponent.amqpComponent("amqp://localhost:5672", "quarkus", "quarkus");

    public void configure(){
        from("amqp:queue:incoming")
            to()
            .setBody(exchange -> "receving message")
            .log("sending message: " + "$body");
    }
    
}
