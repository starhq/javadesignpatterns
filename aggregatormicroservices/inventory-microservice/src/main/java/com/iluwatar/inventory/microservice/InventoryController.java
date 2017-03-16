package com.iluwatar.inventory.microservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by starhq on 2017/3/16.
 */
@RestController
public class InventoryController {

    @RequestMapping(value = "/inventories", method = RequestMethod.GET)
    public int getProductInventories() {
        return 5;
    }
}
