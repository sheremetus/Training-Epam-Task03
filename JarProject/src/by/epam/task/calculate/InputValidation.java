package by.epam.task.calculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    public static String messageOfFailedValidation = "Incorrect data entry format! " +
            "Please check your expression and try again";

    public static boolean validateOfMathematicalExpression(String expression) {
        int numberOfRightBrackets = 0;
        int numberOfLeftBrackets = 0;


        Pattern invalidSymbolPattern  = Pattern.compile("[^\\d\\s\\(\\)\\-\\+/\\*]+");
        Pattern twoOperandsPattern = Pattern.compile("[+\\-/*]{2,}");
        Pattern startingWithMinusPattern  = Pattern.compile("^-\\d");
        Pattern rightBracketPattern  = Pattern.compile("\\(");
        Pattern leftBracketPattern = Pattern.compile("\\)");

        Matcher matcher1 = invalidSymbolPattern.matcher(expression);
        Matcher matcher2 = twoOperandsPattern.matcher(expression);
        Matcher matcher3 = startingWithMinusPattern.matcher(expression);
        Matcher matcher4 = rightBracketPattern.matcher(expression);
        Matcher matcher5 = leftBracketPattern.matcher(expression);

        while (matcher4.find()) {
            numberOfRightBrackets++;
        }
        while (matcher5.find()) {
            numberOfLeftBrackets++;
        }

        return (!matcher1.find() && !matcher2.find() && !matcher3.find() && numberOfRightBrackets == numberOfLeftBrackets);
    }
}
