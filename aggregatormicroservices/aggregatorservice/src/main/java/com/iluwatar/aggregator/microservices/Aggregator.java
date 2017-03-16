package com.iluwatar.aggregator.microservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by starhq on 2017/3/16.
 */
@RestController
public class Aggregator {

    @Resource
    private ProductInformationClient informationClient;

    @Resource
    private ProductInventoryClient inventoryClient;


    /**
     * Retrieves product data.
     *
     * @return a Product.
     */
    @RequestMapping("/product")
    public Product getProduct() {
        Product product = new Product();
        product.setTitle(informationClient.getProductTitle());
        product.setProductInventories(inventoryClient.getProductInventories());
        return product;
    }
}
