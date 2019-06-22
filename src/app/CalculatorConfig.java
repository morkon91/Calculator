package app;

import java.util.Arrays;
import java.util.List;

public class CalculatorConfig {

    public static List<String> SUPPORTED_OPERATORS = Arrays.asList("\\/", "\\*", "\\-", "\\+");

    public static List<String> ROME_NUMBERS = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
            "IX", "V", "IV","III", "II", "I");

    public static List<String> ARABIC_NUMBERS = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    public static int MIN_ARG_VALUE = 1;

    public static int MAX_ARG_VALUE = 10;
}
