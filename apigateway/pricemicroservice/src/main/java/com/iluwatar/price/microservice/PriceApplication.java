package com.iluwatar.price.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by starhq on 2017/3/16.
 */
@SpringBootApplication
public class PriceApplication {

    /**
     * Microservice entry point
     * @param args
     *          command line args
     */
    public static void main(String[] args) {
        SpringApplication.run(PriceApplication.class, args);
    }
}
