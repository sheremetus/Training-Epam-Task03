package by.epam.task.calculate;

import java.util.Scanner;

public class InputLogic {
    public String inputWithScanner(String message) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String expression;
        System.out.println(message);
        expression = scanner.nextLine();

        return expression;
    }
}
