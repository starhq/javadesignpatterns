package com.iluwatar.interpreter;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class MultiplyExpressionTest extends ExpressionTest<MultiplyExpression> {

    /**
     * Create a new set of test entries with the expected result
     *
     * @return The list of parameters used during this test
     */
    @Override
    public Stream<Arguments> expressionProvider() {
        return prepareParameters((f, s) -> f * s);
    }

    /**
     * Create a new test instance using the given test parameters and expected result
     */
    public MultiplyExpressionTest() {
        super("*", MultiplyExpression::new);
    }

}
