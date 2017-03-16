package com.iluwatar.price.microservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by starhq on 2017/3/16.
 */
@RestController
public class PriceController {

    /**
     * An endpoint for a user to retrieve a product's price
     * @return A product's price
     */
    @RequestMapping(value = "/price", method = RequestMethod.GET)
    public String getPrice() {
        return "20";
    }
}
