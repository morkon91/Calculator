import java.util.Arrays;
import java.util.List;

public class ExpressionFactory {

    public String deleteWhiteSpace(String s) {
        String stringWithSpase = s.trim();
        if (stringWithSpase.contains(" "))
            stringWithSpase = deleteWhiteSpace(stringWithSpase);
        return stringWithSpase;
    }

    public IExpression getExpression(String mainTask) throws InvalidArgumentException {
        String[] mathOperators = {"\\/", "\\*", "\\-", "\\+"};


        String trigger = null;


        for (String operator : mathOperators) {
            String[] args = mainTask.split(operator);
            if (args.length == 2) {
                trigger = operator;
                break;
            } else
                trigger = "false";
        }
        if (trigger.equals("false"))
            throw new InvalidArgumentException("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления");




        switch (trigger) {

            case ("\\*"):
                return new CalcMultiplication();

            case ("\\/"):
                return new CalcDivision();

            case ("\\-"):
                return new CalcSubtraction();

            case ("\\+"):
                return new CalcAddition();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public int[] checkAndGetArguments(String mainTask) throws InvalidArgumentException {
        String[] args = null;
        String[] mathOperators = {"\\/", "\\*", "\\-", "\\+"};
        for (String operator : mathOperators) {
            args = mainTask.split(operator);
            if (args.length == 2) {
                break;
            }
        }

        List<String> romeNumbers = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I");
        List<String> arabicNumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");

        boolean hasRomeNumbers = false;
        boolean hasArabicNumbers = false;

        for (String arg : args) {
            if (romeNumbers.contains(deleteWhiteSpace(arg))) {
                hasRomeNumbers = true;
            }
            if (arabicNumbers.contains(deleteWhiteSpace(arg))) {
                hasArabicNumbers = true;
            }
        }

        if (hasRomeNumbers && hasArabicNumbers) {
            throw new InvalidArgumentException("Выражение может содержать либо только арабские, либо только римские цифры");
        }


        int[] intArgs = new int[args.length];
        for (int i = 0; i < args.length; i++) {

            if (hasArabicNumbers && !hasRomeNumbers)
                intArgs[i] = Integer.parseInt(deleteWhiteSpace(args[i]));

            if (!hasArabicNumbers && hasRomeNumbers){
                ArabicToRoman toRoman = new ArabicToRoman();
                intArgs[i] = toRoman.RometoArab(deleteWhiteSpace(args[i]));
            }
            if ((intArgs[i] < 1) || (intArgs[i] > 10))
                throw new InvalidArgumentException("Калькулятор умеет работать с цифрами от 1 до 10 включительно.");
        }

        return intArgs;
    }
}




