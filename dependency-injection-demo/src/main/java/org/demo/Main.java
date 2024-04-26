package org.demo;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import org.demo.service.MobileCoverService;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private MobileCoverService service;

    @Override
    public int run(String... args) throws Exception {
//        MobileCoverService service = new MobileCoverService();
        System.out.println(service.addCover("Black Panther Cover", 250));
        return 0;
    }
}
