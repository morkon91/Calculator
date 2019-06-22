package app;


import app.parsing.ArabicToRoman;
import app.parsing.InvalidArgumentException;


import java.io.BufferedReader;

import java.io.InputStreamReader;


public class CalculatorMain {

    public static boolean romeResult = false;


    public static void main(String[] args) throws InvalidArgumentException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String task = null;
        int result = 0;

        ArabicToRoman arabicToRoman = new ArabicToRoman();


        try {
            while (!"exit".equals(task = reader.readLine())) {
                ExpressionFactory expressionFactory = new ExpressionFactory();
                result = (int) expressionFactory.getExpression(task).execute();

                if (romeResult){
                    System.out.println(arabicToRoman.convertIntegerToRoman(result));
                romeResult = false; }
                else
                System.out.println(result);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
