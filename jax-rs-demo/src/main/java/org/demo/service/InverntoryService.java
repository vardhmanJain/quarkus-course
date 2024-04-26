package org.demo.service;

import org.demo.entity.Book;

import java.util.List;

public interface InverntoryService<T> {
    List<T> getAll();
    T getById(int id);
    boolean delete(int id);
    T update(int id, T item);
    T add(T item);
}
