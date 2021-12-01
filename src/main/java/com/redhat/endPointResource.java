package com.redhat;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.camel.ProducerTemplate;

@Path("/api")
public class endPointResource {

    @Inject
    ProducerTemplate producer;
    
    @POST
    @Path("/send")
    @Produces(MediaType.TEXT_PLAIN)
    public String send(){
        String requestBody = producer.requestBody("direct:amq", "demo", String.class);
        return requestBody;
    }

    @POST
    @Path("/receive")
    @Produces(MediaType.TEXT_PLAIN)
    public String receive(){
        return "";

    }



}
