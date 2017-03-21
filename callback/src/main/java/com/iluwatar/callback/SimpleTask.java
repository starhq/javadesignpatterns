package com.iluwatar.callback;

/**
 * Created by starhq on 2017/3/21.
 */
public class SimpleTask extends Task {
    @Override
    public void execute() {
        System.out.println("Perform some important activity and after call the callback method.");
    }
}
