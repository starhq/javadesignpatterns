package com.iluwatar.flux.view;

import com.iluwatar.flux.store.Store;

/**
 * Created by starhq on 2017/4/1.
 */
public interface View {

    void storeChanged(Store store);

    void render();
}
