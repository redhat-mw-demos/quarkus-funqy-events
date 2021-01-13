package org.acme;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Set;

@RegisterRestClient(baseUri = "http://quarkus-cache-knativetutorial.apps.cluster-00d0.00d0.example.opentlc.com")
public interface InputService {

    @GET
    @Path("/api")
    Set<Input> getAll();

    @POST
    @Path("/api")
    void postInput(Input input);


}
