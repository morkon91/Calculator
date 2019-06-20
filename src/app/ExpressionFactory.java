package app;

import app.expressions.IExpression;
import app.expressions.impl.AdditionExpression;
import app.expressions.impl.DivisionExpression;
import app.expressions.impl.MultiplicationExpression;
import app.expressions.impl.SubtractionExpression;
import app.parsing.InvalidArgumentException;
import app.parsing.StringArgumentParser;

public class ExpressionFactory {

    public IExpression getExpression(String mainTask) throws InvalidArgumentException {

        StringArgumentParser parser = new StringArgumentParser();
        parser.parse(mainTask);

        String targetOperator = parser.getTargetOperator();
        int[] arguments = parser.getArguments();

        switch (targetOperator) {
            case ("\\*"):
                return new MultiplicationExpression(arguments[0], arguments[1]);

            case ("\\/"):
                return new DivisionExpression(arguments[0], arguments[1]);

            case ("\\-"):
                return new SubtractionExpression(arguments[0], arguments[1]);

            case ("\\+"):
                return new AdditionExpression(arguments[0], arguments[1]);
            default:
                throw new UnsupportedOperationException();
        }
    }
}




