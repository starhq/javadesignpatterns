package com.iluwatar.information.microservice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by starhq on 2017/3/16.
 */
public class InformationControllerTest {

    @Test
    public void shouldGetProductTitle() {
        InformationController infoController = new InformationController();

        String title = infoController.getProductTitle();

        Assert.assertEquals("The Product Title.", title);
    }
}
