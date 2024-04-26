package org.demo.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.demo.entity.Book;
import org.demo.service.InverntoryService;

import java.awt.*;
import java.util.List;

@Path("/book")
public class BookController {

    @Inject
    InverntoryService<Book> service;
    @GET
    public List<Book> getAllBooks(){
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public Response getBook(@PathParam("id") int id){
        Book book = service.getById(id);
        if(book == null)return  Response.status(404).build();
        return Response.ok(book).status(200).build();
    }

    @POST
    public Book addBook(Book book){
        return service.add(book);
    }

    @DELETE
    @Path("/{id}")
    public boolean deleteBook(@PathParam("id") int id){
        return  service.delete(id);
    }

    @PUT
    @Path("/{id}")
    public Book upateBook(@PathParam("id") int id, Book book){
        return service.update(id, book);
    }
}
