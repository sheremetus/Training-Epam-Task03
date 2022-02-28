package by.epam.task.calculate;

import java.util.*;

public class CalculatorLogic {

    private static String expressionToRpn(String expression) {


        StringBuilder current = new StringBuilder();
        Stack<Character> operators = new Stack<>();

        int priority;
        for (int i = 0; i < expression.length(); i++) {
            priority = getPriority(expression.charAt(i));
            if (priority == 0) {
                current.append(expression.charAt(i));
            }
            if (priority == 1) {
                operators.push(expression.charAt(i));
            }
            if (priority > 1) {
                current.append(' ');
                while (!operators.empty()) {
                    if (getPriority(operators.peek()) >= priority) {
                        current.append(operators.pop());
                    } else {
                        break;
                    }
                }
                operators.push(expression.charAt(i));
            }
            if (priority == -1) {
                current.append(' ');
                while (getPriority(operators.peek()) != 1) {
                    current.append(operators.pop());

                }
                operators.pop();
            }
        }
        while (!operators.empty()) {
            current.append(operators.pop());
        }

        return current.toString();

    }

    public static double calculate(String expression) {

        if (!InputValidation.validateOfMathematicalExpression(expression)) {
            System.out.println(InputValidation.messageOfFailedValidation);
            throw new IncorrectInputException();
        }

        String rpn = expressionToRpn(expression);

        String operand = "";
        Stack<Double> result = new Stack<>();

        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') continue;
            if (getPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) == 0) {
                    operand += rpn.charAt(i++);
                    if (i == rpn.length()) {
                        break;
                    }

                }

                result.push(Double.parseDouble(operand));
                operand = "";
            }
            if (getPriority(rpn.charAt(i)) > 1) {
                double a = result.pop();
                double b = result.pop();
                if (rpn.charAt(i) == '+') {
                    result.push(b + a);
                }
                if (rpn.charAt(i) == '-') {
                    result.push(b - a);
                }
                if (rpn.charAt(i) == '*') {
                    result.push(b * a);
                }
                if (rpn.charAt(i) == '/') {
                    result.push(b / a);
                }
            }

        }

        return result.pop();
    }

    private static int getPriority(char token) {
        if (token == '*' || token == '/') {
            return 3;
        } else if (token == '+' || token == '-') {
            return 2;
        } else if (token == '(') {
            return 1;
        } else if (token == ')') {
            return -1;
        } else {
            return 0;
        }
    }
}
