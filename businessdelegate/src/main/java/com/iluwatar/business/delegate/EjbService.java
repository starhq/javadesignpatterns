package com.iluwatar.business.delegate;

/**
 * Created by starhq on 2017/3/21.
 */
public class EjbService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("EjbService is now processing");
    }
}
