package baseball;

import java.util.Scanner;

public class GameManager {

    private CorrectAnswer correctAnswer;
    private final Scanner scanner = new Scanner(System.in);
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private void init() {
        correctAnswer = new CorrectAnswer();
    }

    private UserAnswer inputNumber() {
        int input = inputView.getInput();

        int firstInput = input / 100;
        int secondInput = input % 100 / 10;
        int thirdInput = input % 10;

        return new UserAnswer(firstInput, secondInput, thirdInput);
    }
}
