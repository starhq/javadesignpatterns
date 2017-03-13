package com.iluwatar.abstractfactory.abstractdocument.domain;

import com.iluwatar.abstractfactory.abstractdocument.AbstractDocument;

import java.util.Map;

/**
 * Created by starhq on 2017/2/27.
 */
public class Car extends AbstractDocument implements HasModel, HasParts, HasPrice {

    public Car(Map<String, Object> properties) {
        super(properties);
    }
}
