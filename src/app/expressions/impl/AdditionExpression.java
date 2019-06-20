package app.expressions.impl;

import app.expressions.AbstractExpression;

public class AdditionExpression extends AbstractExpression {

    public AdditionExpression(int a, int b) {
        super(a, b);
    }

    @Override
    public double execute() {
        return a + b;
    }
}
