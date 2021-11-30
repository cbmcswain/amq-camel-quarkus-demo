package com.redhat;

import org.apache.camel.builder.RouteBuilder;

public class receiveRoute extends RouteBuilder{

    public void configure(){
        rest("/api/receive")
            .post().route().setBody(constant("receiving message"));
            log.info("receiving message");
    }
    
}
