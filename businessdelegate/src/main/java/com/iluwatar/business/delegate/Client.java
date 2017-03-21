package com.iluwatar.business.delegate;

/**
 * Created by starhq on 2017/3/21.
 */
public class Client {

    private BusinessDelegate businessDelegate;

    public Client(BusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    public void doTask() {
        businessDelegate.doTask();
    }
}
