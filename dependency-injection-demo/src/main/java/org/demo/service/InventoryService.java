package org.demo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Singleton;
import org.demo.entity.Cover;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class InventoryService {
    List<Cover> inventory = new ArrayList<>();

    public void coverAdded(@Observes Cover cover){
        inventory.add(cover);

        System.out.println("Cover addded to inventory");
    }
}
