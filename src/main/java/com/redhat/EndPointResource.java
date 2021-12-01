package com.redhat;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.apache.camel.ProducerTemplate;

@Path("/api")
public class EndPointResource {

    @Inject
    ProducerTemplate producer;

    @POST
    @Path("/send")
    @Produces()
    public String send() {
        String requestBody = producer.requestBody("direct:amq", "Demo Message Hello", String.class);
        return requestBody;
    }

    @POST
    @Path("/receive")
    @Produces()
    public String receive() {
        return "";

    }

}
