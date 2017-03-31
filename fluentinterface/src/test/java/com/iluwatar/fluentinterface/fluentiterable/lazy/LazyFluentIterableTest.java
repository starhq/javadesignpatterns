package com.iluwatar.fluentinterface.fluentiterable.lazy;

import com.iluwatar.fluentinterface.fluentiterable.FluentIterable;
import com.iluwatar.fluentinterface.fluentiterable.FluentIterableTest;

/**
 * Created by starhq on 2017/3/31.
 */
public class LazyFluentIterableTest extends FluentIterableTest {

    @Override
    protected FluentIterable<Integer> createFluentIterable(Iterable<Integer> integers) {
        return LazyFluentIterable.from(integers);
    }

}
