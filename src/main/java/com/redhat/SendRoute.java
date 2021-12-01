package com.redhat;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
public class SendRoute extends RouteBuilder{

    public void configure(){
        from("direct:amq")
            .setExchangePattern(ExchangePattern.InOnly)
            .log("Sending Message: " + "${body}")
            .to("amqp:queue:demo-queue");
    }
    
}
