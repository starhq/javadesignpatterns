package com.iluwatar.image.microservice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by starhq on 2017/3/16.
 */
public class ImageControllerTest {

    @Test
    public void testGetImagePath() {
        ImageController imageController = new ImageController();

        String imagePath = imageController.getImagePath();

        Assert.assertEquals("/product-image.png", imagePath);
    }
}
