package app.expressions;

public abstract class AbstractExpression implements IExpression {

    protected final int a;
    protected final int b;

    public AbstractExpression(int a, int b) {
        this.a = a;
        this.b = b;
    }
}