package by.epam.task.calculate;

public class Controller {

    public static void main(String[] args) {
        String expression;
        String message = "Please enter a valid mathematical " +
                "expression with natural numbers. Expression can contain brackets";
        InputLogic inputLogic = new InputLogic();
        OutputLogic outputLogic = new OutputLogic();


        expression = inputLogic.inputWithScanner(message);
        outputLogic.showResult(CalculatorLogic.calculate(expression));

    }
}
