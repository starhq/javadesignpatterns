package com.iluwatar.abstractfactory.abstractdocument.domain;

import com.iluwatar.abstractfactory.abstractdocument.Document;

import java.util.Optional;

/**
 * Created by starhq on 2017/2/27.
 */
public interface HasModel extends Document {

    String PROPERTY = "model";

    default Optional<String> getModel() {
        return Optional.ofNullable((String) get(PROPERTY));
    }
}
