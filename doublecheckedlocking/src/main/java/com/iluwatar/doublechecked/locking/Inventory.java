package com.iluwatar.doublechecked.locking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by starhq on 2017/3/24.
 */
public class Inventory {

    private final int inventorySize;
    private final List<Item> items;
    private final Lock lock;

    public Inventory(int inventorySize) {
        this.inventorySize = inventorySize;
        this.items = new ArrayList<>(inventorySize);
        this.lock = new ReentrantLock();
    }

    public boolean addItem(Item item) {
        if (items.size() < inventorySize) {
            lock.lock();
            try {
                if (items.size() < inventorySize) {
                    items.add(item);
                    System.out.println(Thread.currentThread() + ": items.size()=" + items.size()
                            + ", inventorySize=" + inventorySize);
                    return true;
                }
            } finally {
                lock.unlock();
            }
        }
        return true;
    }

    public final List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
