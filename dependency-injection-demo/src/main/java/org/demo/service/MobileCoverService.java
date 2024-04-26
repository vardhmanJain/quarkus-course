package org.demo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import org.demo.annotations.DateType;
import org.demo.annotations.Uuid;
import org.demo.entity.Cover;
import org.demo.utility.IdGenerator;

@ApplicationScoped
public class MobileCoverService {

    @Inject
    Event<Cover> coverAddedEvent;
    @Inject @Uuid
    IdGenerator idGenerator;
    public Cover addCover(String name, double price){
        String id = idGenerator.generateUniqueId();
        Cover cover = new Cover();
        cover.setId(id);
        cover.setName(name);
        cover.setPrice(price);
        coverAddedEvent.fire(cover);
        return cover;
    }
}
