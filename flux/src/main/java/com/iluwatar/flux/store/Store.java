package com.iluwatar.flux.store;

import com.iluwatar.flux.action.Action;
import com.iluwatar.flux.view.View;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by starhq on 2017/4/1.
 */
public abstract class Store {

    private List<View> views = new LinkedList<>();

    public abstract void onAction(Action action);

    public void registerView(View view) {
        views.add(view);
    }

    protected void notifyChange() {
        views.stream().forEach(view -> view.storeChanged(this));
    }
}
