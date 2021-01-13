package org.acme;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/load")
public class GreetingResource {

    @Inject
    @RestClient
    InputService inputService;

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("/gen/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response generate(@PathParam("id") Long id){
        GenerateFullNames names = new GenerateFullNames("FNames.txt", "LNames.txt");
        GeneratePhoneNumbers number = new GeneratePhoneNumbers();
        GenerateCountries countries = new GenerateCountries("Countries");

        for(int i = 0; i < id; i++){

            Input input =  new Input(names.getNextFullName(), countries.getCountry(), number.getNextPhoneNumber());
            System.out.println(input);
         //   inputService.postInput(input);
        }

        return Response.status(Response.Status.CREATED).entity(id).build();
    }

}