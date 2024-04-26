package org.demo.entitiy;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class Book {
    @NotNull @Min(1)
    int id;
    @NotNull
    String title;
    @NotNull
    String author;
    @NotNull
    String publisher;

    @PastOrPresent
    LocalDate publishedOn;

    public Book(int id, String title, String author,String publisher,  LocalDate publishedOn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedOn = publishedOn;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedOn=" + publishedOn +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(LocalDate publishedOn) {
        this.publishedOn = publishedOn;
    }
}
