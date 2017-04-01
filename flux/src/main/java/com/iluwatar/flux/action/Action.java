package com.iluwatar.flux.action;

/**
 * Created by starhq on 2017/4/1.
 */
public abstract class Action {

    private ActionType type;

    public Action(ActionType type) {
        this.type = type;
    }

    public ActionType getType() {
        return type;
    }
}
