package app.expressions.impl;

import app.expressions.AbstractExpression;

public class DivisionExpression extends AbstractExpression {


    public DivisionExpression(int a, int b) {
        super(a, b);
    }

    @Override
    public double execute() {
        return a / b;
    }
}
