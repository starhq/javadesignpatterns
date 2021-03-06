package com.iluwatar.singleton;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public abstract class SingletonTest<S> {

    /**
     * The singleton's getInstance method
     */
    private final Supplier<S> singletonInstanceMethod;

    /**
     * Create a new singleton test instance using the given 'getInstance' method
     *
     * @param singletonInstanceMethod The singleton's getInstance method
     */
    public SingletonTest(final Supplier<S> singletonInstanceMethod) {
        this.singletonInstanceMethod = singletonInstanceMethod;
    }

    /**
     * Test the singleton in a non-concurrent setting
     */
    @Test
    public void testMultipleCallsReturnTheSameObjectInSameThread() {
        // Create several instances in the same calling thread
        S instance1 = this.singletonInstanceMethod.get();
        S instance2 = this.singletonInstanceMethod.get();
        S instance3 = this.singletonInstanceMethod.get();
        // now check they are equal
        assertSame(instance1, instance2);
        assertSame(instance1, instance3);
        assertSame(instance2, instance3);
    }

    /**
     * Test singleton instance in a concurrent setting
     */
    @Test
    public void testMultipleCallsReturnTheSameObjectInDifferentThreads() throws Exception {
        assertTimeout(ofMillis(10000), () -> {
            // Create 10000 tasks and inside each callable instantiate the singleton class
            final List<Callable<S>> tasks = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                tasks.add(this.singletonInstanceMethod::get);
            }

            // Use up to 8 concurrent threads to handle the tasks
            final ExecutorService executorService = Executors.newFixedThreadPool(8);
            final List<Future<S>> results = executorService.invokeAll(tasks);

            // wait for all of the threads to complete
            final S expectedInstance = this.singletonInstanceMethod.get();
            for (Future<S> res : results) {
                final S instance = res.get();
                assertNotNull(instance);
                assertSame(expectedInstance, instance);
            }

            // tidy up the executor
            executorService.shutdown();
        });

    }

}
