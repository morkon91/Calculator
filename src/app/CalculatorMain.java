package app;

import app.parsing.InvalidArgumentException;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CalculatorMain {

    public static void main(String[] args) throws InvalidArgumentException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String task = null;
        try {
            while (!"exit".equals(task = reader.readLine())) {
                ExpressionFactory expressionFactory = new ExpressionFactory();
                System.out.println((int) expressionFactory.getExpression(task).execute());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
