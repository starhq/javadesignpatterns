package com.iluwatar.callback;

/**
 * Created by starhq on 2017/3/21.
 */
public class LambdasApp {

    public static void main(String[] args) {
        Task task = new SimpleTask();
        task.executeWith(() -> System.out.println("I 'm done now"));
    }
}
