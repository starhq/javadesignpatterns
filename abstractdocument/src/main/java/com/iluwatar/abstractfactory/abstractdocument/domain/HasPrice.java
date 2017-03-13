package com.iluwatar.abstractfactory.abstractdocument.domain;

import com.iluwatar.abstractfactory.abstractdocument.Document;

import java.util.Optional;

/**
 * Created by starhq on 2017/2/27.
 */
public interface HasPrice extends Document {

    String PROPERTY = "price";

    default Optional<Number> getPrice() {
        return Optional.ofNullable((Number) get(PROPERTY));
    }
}
