package baseball;

import java.util.Scanner;

public class GameManager {

    private CorrectAnswer correctAnswer;
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        correctAnswer = new CorrectAnswer();
    }

    private UserAnswer inputNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        int input = scanner.nextInt();

        int firstInput = input / 100;
        int secondInput = input % 100 / 10;
        int thirdInput = input % 10;

        System.out.println();
        return new UserAnswer(firstInput, secondInput, thirdInput);
    }
}
