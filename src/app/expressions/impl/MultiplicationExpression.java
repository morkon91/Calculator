package app.expressions.impl;

import app.expressions.AbstractExpression;

public class MultiplicationExpression extends AbstractExpression {

    public MultiplicationExpression(int a, int b) {
        super(a, b);
    }

    @Override
    public double execute() {
        return a * b;
    }
}
