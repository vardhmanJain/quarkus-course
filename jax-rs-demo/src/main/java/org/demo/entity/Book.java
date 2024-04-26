package org.demo.entity;

import java.time.LocalDate;

public class Book {
    String title;
    int id;
    String author;
    LocalDate pusblishedOn;

    public Book( int id,String title, String author, LocalDate pusblishedOn) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.pusblishedOn = pusblishedOn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", author='" + author + '\'' +
                ", pusblishedOn=" + pusblishedOn +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPusblishedOn() {
        return pusblishedOn;
    }

    public void setPusblishedOn(LocalDate pusblishedOn) {
        this.pusblishedOn = pusblishedOn;
    }
}
