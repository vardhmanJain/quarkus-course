package org.demo.service;

import jakarta.inject.Singleton;
import org.demo.entity.Book;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
public class BookInventoryService implements InverntoryService<Book>{

    List<Book> inventory;

    BookInventoryService(){
        inventory = new ArrayList<>(Arrays.asList(new Book(21,"The Alchemist", "Paulo Cohelo", LocalDate.of(2008, Month.JANUARY, 21)),
                new Book(223,"Diary of a Young Girl", "Paulo Cohelo", LocalDate.of(2008, Month.JANUARY, 21)),
                new Book(231,"asd;lfkja", "Paulo Cohelo",  LocalDate.of(2008, Month.JANUARY, 21)),
                new Book(751,"asdfast", "Paulo Cohelo",  LocalDate.of(2008, Month.JANUARY, 21)),
                new Book(41,"aslrkjtqw", "Paulo Cohelo",  LocalDate.of(2008, Month.JANUARY, 21))));
    }

    @Override
    public List<Book> getAll() {
        return inventory;
    }

    @Override
    public Book getById(int id) {
        for(Book book: inventory){
            if(book.getId() == id)return book;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Book bookToDelete = getById(id);
        if(bookToDelete != null){inventory.remove(bookToDelete); return true;}
        return false;
    }

    @Override
    public Book update(int id, Book item) {
        Book bookToUpdate = getById(id);
        if(bookToUpdate != null){
            inventory.remove(bookToUpdate);
            inventory.add(item);
            return item;
        }
        return null;
    }

    @Override
    public Book add(Book item) {
        Book bookToAdd = getById(item.getId());
        if(bookToAdd == null){inventory.add(item);return item;}
        return null;
    }
}
