package com.redhat;

import javax.enterprise.inject.Produces;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.amqp.AMQPComponent;

public class SendRoute extends RouteBuilder{

//    AMQPComponent authorizedAmqp = AMQPComponent.amqpComponent("amqp://localhost:5672", "quarkus", "quarkus");

    public void configure(){
        from("direct:amq")
            .log("sending message: " + "${body}")
            .to("amqp:queue:danny-queue");
    }
    
}
