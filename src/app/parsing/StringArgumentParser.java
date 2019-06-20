package app.parsing;

import app.CalculatorConfig;

public class StringArgumentParser {

    private String targetOperator = null;
    private int[] arguments = null;
    private ArabicToRoman toRoman = new ArabicToRoman();

    public void parse(String task) {
        String[] dirtyArgs = null;
        for (String operator : CalculatorConfig.SUPPORTED_OPERATORS) {
            dirtyArgs = task.split(operator);
            if (dirtyArgs.length == 2) {
                targetOperator = operator;
                break;
            }
        }
        if (dirtyArgs.length == 1) {
            throw new UnsupportedOperationException("Ошибка оператора");
        }

        String[] argumentsWithoutWhiteSpaces = new String[dirtyArgs.length];
        for (int i = 0; i < dirtyArgs.length; i++) {
            argumentsWithoutWhiteSpaces[i] = deleteWhiteSpace(dirtyArgs[i]);
        }

        boolean hasRomeNumbers = false;
        boolean hasArabicNumbers = false;

        for (String arg : argumentsWithoutWhiteSpaces) {
            if (CalculatorConfig.ROME_NUMBERS.contains(arg)) {
                hasRomeNumbers = true;
            }
            if (CalculatorConfig.ARABIC_NUMBERS.contains(arg)) {
                hasArabicNumbers = true;
            }
        }

        if (hasRomeNumbers && hasArabicNumbers) {
            throw new InvalidArgumentException("Выражение может содержать либо только арабские, либо только римские цифры");
        }

        int[] intArgs = new int[argumentsWithoutWhiteSpaces.length];
        for (int i = 0; i < argumentsWithoutWhiteSpaces.length; i++) {
            if (hasArabicNumbers && !hasRomeNumbers)
                intArgs[i] = Integer.parseInt(argumentsWithoutWhiteSpaces[i]);

            if (!hasArabicNumbers && hasRomeNumbers){
                intArgs[i] = toRoman.RometoArab(argumentsWithoutWhiteSpaces[i]);
            }
            if ((intArgs[i] < CalculatorConfig.MIN_ARG_VALUE) || (intArgs[i] > CalculatorConfig.MAX_ARG_VALUE))
                throw new InvalidArgumentException("Калькулятор умеет работать с цифрами от 1 до 10 включительно.");
        }
        arguments = intArgs;
    }

    private String deleteWhiteSpace(String s) {
        String stringWithSpace = s.trim();
        if (stringWithSpace.contains(" "))
            stringWithSpace = deleteWhiteSpace(stringWithSpace);
        return stringWithSpace;
    }

    public String getTargetOperator() {
        return targetOperator;
    }

    public int[] getArguments() {
        return arguments;
    }
}
