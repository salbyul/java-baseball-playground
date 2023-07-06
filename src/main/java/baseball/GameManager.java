package baseball;

import java.util.Scanner;

public class GameManager {

    private CorrectAnswer correctAnswer;
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        correctAnswer = new CorrectAnswer();
    }

    private Integer inputNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        int input = scanner.nextInt();
        System.out.println();
        return input;
    }
}
