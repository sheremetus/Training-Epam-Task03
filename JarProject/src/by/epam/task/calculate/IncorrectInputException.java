package by.epam.task.calculate;

public class IncorrectInputException extends RuntimeException {
    public IncorrectInputException() {
        super("Incorrect input data");
    }
}
