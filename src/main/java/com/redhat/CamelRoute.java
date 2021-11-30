package com.redhat;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

@ApplicationScoped
public class CamelRoute extends EndpointRouteBuilder{
    
    @Override
    public void configure() throws Exception {
        from(platformHttp("camel/hello"))
            .setBody().simple("Camel runs on ${hostname}")
            .to(log("hi").showExchangePattern(false).showBodyType(false));
        
    }
}
