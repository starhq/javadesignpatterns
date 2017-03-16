package com.iluwatar.price.microservice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by starhq on 2017/3/16.
 */
public class PriceControllerTest {

    @Test
    public void testgetPrice() {
        PriceController priceController = new PriceController();

        String price = priceController.getPrice();

        Assert.assertEquals("20", price);
    }
}
