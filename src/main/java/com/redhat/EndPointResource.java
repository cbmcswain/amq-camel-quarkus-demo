package com.redhat;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.apache.camel.ProducerTemplate;

@Path("/api")
public class EndPointResource {

    @Inject
    ProducerTemplate producer;

    @POST
    @Path("/send")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String send(String body) {
        producer.requestBody("direct:amq", body , String.class);
        return "Sending message " + body;
    }

}
