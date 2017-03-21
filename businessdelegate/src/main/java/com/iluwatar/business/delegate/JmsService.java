package com.iluwatar.business.delegate;

/**
 * Created by starhq on 2017/3/21.
 */
public class JmsService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("JmsService is now processing");
    }
}
