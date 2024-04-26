package org.demo.controller;

import io.smallrye.common.constraint.Assert;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.demo.entitiy.Book;
import org.demo.service.InventoryService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.print.attribute.standard.Media;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Set;

@Path("/book")
public class BookController {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hell(){
        return "Hello World!!";
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public Response welcome(){
        return Response.ok(new Book(123413, "One night stand", "Vardhman Jain", "Penguin hous", LocalDate.of(2024, Month.DECEMBER, 5))).status(500).build();
    }

    @Inject
    InventoryService<Book> inventory;
    @GET
    @Operation(summary = "Returns the list of all available books.")
    public List<Book> getAllBooks(){
            return inventory.getAll();
    }

    @GET
    @Path("/{id}")
    @APIResponse(responseCode = "200", description = "Book with the given id exists")
    @APIResponse(responseCode = "404", description = "The request resource doesen't exist")
    public Response get(@Parameter(description = "book identifier", required = true) @PathParam("id") int id){
        Book book = inventory.getById(id);
        return book == null? Response.status(404).build(): Response.ok(book).build();
    }

    @DELETE
    @Path("/{id}")
    public boolean delete(@PathParam("id") int id){
        return inventory.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    public Book update(@PathParam("id") int id, @RequestBody @Valid Book book){
        return inventory.update(id, book);
    }

    @Inject
    Validator validator;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(@RequestBody @Valid Book book){
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if(violations.size() > 0)return Response.status(400).entity(new Exception("invalid input")).build();
        return Response.ok(inventory.add(book)).build();
    }
}
