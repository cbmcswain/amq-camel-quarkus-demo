package com.redhat;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;

public class ReceiveRoute extends RouteBuilder{

    public void configure(){
        from("amqp:queue:demo-queue")
        .setExchangePattern(ExchangePattern.InOnly)
        .log("Message Received: " + "${body}");
    }   
}
