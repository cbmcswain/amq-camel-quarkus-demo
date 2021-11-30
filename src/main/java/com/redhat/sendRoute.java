package com.redhat;

import org.apache.camel.builder.RouteBuilder;

public class sendRoute extends RouteBuilder{

    public void configure() {
        rest("/api/send")
            .post().route().setBody(constant("sending message"));
            log.info("sending message");

    }
    
}
