package org.acme;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.counter.api.CounterManager;

import io.quarkus.infinispan.client.Remote;
@Path("/api")
public class GreetingResource {

    @Inject
    InputService inputService;

    @OPTIONS
    public Response opt() {
        return Response.ok().build();
    }

    @GET
    @Path("/hello")
    public String hello() {
        return "hello";
    }

    @GET
    public List<Input> getAll() {
        return new ArrayList<>(inputService.getAll());
    }

    public Response getOne(@Valid Input input){
        input = inputService.getEntry(input);
        return Response.status(Response.Status.CREATED).entity(input).build();
    }

    @POST
    @Transactional
    public Response create(@Valid Input item) {
        inputService.save(item);
        return Response.status(Response.Status.CREATED).entity(item).build();
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Response update(@Valid Input input, @PathParam("id") Long id) {
        inputService.save(input);
        return Response.status(Response.Status.CREATED).entity(input).build();

    }

    @DELETE
    @Transactional
    public Response delete() {
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id) {
        return Response.noContent().build();
    }


}