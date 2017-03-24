package com.iluwatar.dependency.injection;

import com.google.inject.AbstractModule;

/**
 * Created by starhq on 2017/3/24.
 */
public class TobaccoModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Tobacco.class).to(RivendellTobacco.class);
    }
}
