package com.iluwatar.fluentinterface.fluentiterable.simple;

import com.iluwatar.fluentinterface.fluentiterable.FluentIterable;
import com.iluwatar.fluentinterface.fluentiterable.FluentIterableTest;

/**
 * Created by starhq on 2017/3/31.
 */
public class SimpleFluentIterableTest extends FluentIterableTest {
    @Override
    protected FluentIterable<Integer> createFluentIterable(Iterable<Integer> integers) {
        return SimpleFluentIterable.fromCopyOf(integers);
    }
}
