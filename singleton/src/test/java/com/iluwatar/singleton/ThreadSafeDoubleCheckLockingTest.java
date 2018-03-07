package com.iluwatar.singleton;

public class ThreadSafeDoubleCheckLockingTest extends SingletonTest<ThreadSafeDoubleCheckLocking> {

    /**
     * Create a new singleton test instance using the given 'getInstance' method
     */
    public ThreadSafeDoubleCheckLockingTest() {
        super(ThreadSafeDoubleCheckLocking::getInstance);
    }

}
