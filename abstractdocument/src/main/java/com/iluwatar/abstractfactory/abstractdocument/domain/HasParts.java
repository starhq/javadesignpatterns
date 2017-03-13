package com.iluwatar.abstractfactory.abstractdocument.domain;

import com.iluwatar.abstractfactory.abstractdocument.Document;

import java.util.stream.Stream;

/**
 * Created by starhq on 2017/2/27.
 */
public interface HasParts extends Document {

    String PROPERTY = "parts";

    default Stream<Part> getParts() {
        return children(PROPERTY, Part::new);
    }
}
