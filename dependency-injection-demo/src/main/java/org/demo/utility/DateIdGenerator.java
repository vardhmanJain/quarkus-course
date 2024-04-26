package org.demo.utility;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Singleton;
import org.demo.annotations.DateType;
import org.demo.annotations.Uuid;

import java.util.Date;

@Singleton
@DateType
public class DateIdGenerator implements IdGenerator{


    @Override
    public String generateUniqueId() {
        Date date = new Date();
        return String.valueOf(date.getTime());
    }
}
