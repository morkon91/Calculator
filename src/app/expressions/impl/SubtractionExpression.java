package app.expressions.impl;

import app.expressions.AbstractExpression;

public class SubtractionExpression extends AbstractExpression {

    public SubtractionExpression(int a, int b) {
        super(a, b);
    }

    @Override
    public double execute() {
        return a - b;
    }
}
