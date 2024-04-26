package org.demo.service;

import org.demo.entitiy.Book;

import java.util.List;

public interface InventoryService<T> {
    List<T> getAll();
    T getById(int id);
    boolean deleteById(int id);
    T update(int id, T item);
    T add(T item);

}
