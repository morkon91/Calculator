import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CalculatorMain {

    public static void main(String[] args) throws InvalidArgumentException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String task = null;

        try {
            task = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ExpressionFactory expression = new ExpressionFactory();
        int[] arguments = expression.checkAndGetArguments(task);

        System.out.println((int)expression.getExpression(task).execute(arguments[0], arguments[1]));
    }
}
