package org.demo.service;

import jakarta.inject.Singleton;
import org.demo.entitiy.Book;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
public class BookInventoryService implements InventoryService<Book> {
    List<Book> books = new ArrayList<>(Arrays.asList(new Book(21,"The Alchemist", "Paulo Cohelo", "Penguin", LocalDate.of(2008, Month.JANUARY, 21)),
            new Book(223,"Diary of a Young Girl", "Paulo Cohelo", "Penguin", LocalDate.of(2008, Month.JANUARY, 21)),
            new Book(231,"asd;lfkja", "Paulo Cohelo", "Penguin", LocalDate.of(2008, Month.JANUARY, 21)),
            new Book(751,"asdfast", "Paulo Cohelo", "Penguin", LocalDate.of(2008, Month.JANUARY, 21)),
            new Book(41,"aslrkjtqw", "Paulo Cohelo", "Penguin", LocalDate.of(2008, Month.JANUARY, 21))));
    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public Book add(Book b){
        books.add(b);
        return b;
    }

    @Override
    public Book getById(int id) {
        for(Book b: books){
            if(b.getId() == id) return b;
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        Book remove = null;
        for(Book b : books){
            if(b.getId() == id){
                remove = b;
            }
        }
        if(remove == null)return false;
        books.remove(remove);
        return true;
    }

    @Override
    public Book update(int id, Book item) {
        if(deleteById(id) == false)return null;
        books.add(item);
        return item;
    }
}
