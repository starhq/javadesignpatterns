package com.iluwatar.delegation.simple.printers;

import com.iluwatar.delegation.simple.Printer;

/**
 * Created by starhq on 2017/3/23.
 */
public class CanonPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.print("Canon Printer : " + message);
    }
}
