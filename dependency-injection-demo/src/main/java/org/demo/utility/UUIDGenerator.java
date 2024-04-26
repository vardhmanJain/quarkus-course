package org.demo.utility;

import jakarta.enterprise.inject.Default;
import jakarta.inject.Singleton;
import org.demo.annotations.Uuid;

import java.util.UUID;

@Uuid
@Singleton
public class UUIDGenerator implements IdGenerator{

    @Override
    public String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
