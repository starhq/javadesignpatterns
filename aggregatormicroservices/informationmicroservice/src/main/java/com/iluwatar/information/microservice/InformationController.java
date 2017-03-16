package com.iluwatar.information.microservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by starhq on 2017/3/16.
 */
@RestController
public class InformationController {

    @RequestMapping(value = "/information", method = RequestMethod.GET)
    public String getProductTitle() {
        return "The Product Title.";
    }
}
