package com.iluwatar.abstractfactory.abstractdocument.domain;

import com.iluwatar.abstractfactory.abstractdocument.AbstractDocument;

import java.util.Map;

/**
 * Created by starhq on 2017/2/27.
 */
public class Part extends AbstractDocument implements HasModel, HasPrice, HasType {

    public Part(Map<String, Object> properties) {
        super(properties);
    }
}
