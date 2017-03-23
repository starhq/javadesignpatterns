package com.iluwatar.delegation.simple;

/**
 * Created by starhq on 2017/3/23.
 */
public class PrinterController implements Printer {

    private final Printer printer;

    public PrinterController(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        printer.print(message);
    }
}
