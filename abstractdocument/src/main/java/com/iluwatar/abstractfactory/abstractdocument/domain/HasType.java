package com.iluwatar.abstractfactory.abstractdocument.domain;

import com.iluwatar.abstractfactory.abstractdocument.Document;

import java.util.Optional;

/**
 * Created by starhq on 2017/2/27.
 */
public interface HasType extends Document {

    String PROPERTY = "type";

    default Optional<String> getType() {
        return Optional.ofNullable((String) get(PROPERTY));
    }
}
