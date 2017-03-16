package com.iluwatar.microservice;

import com.iluwatar.inventory.microservice.InventoryController;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by starhq on 2017/3/16.
 */
public class InventoryControllerTest {

    @Test
    public void testGetProductInventories() throws Exception {
        InventoryController inventoryController = new InventoryController();

        int numberOfInventories = inventoryController.getProductInventories();

        Assert.assertEquals(5, numberOfInventories);
    }
}
