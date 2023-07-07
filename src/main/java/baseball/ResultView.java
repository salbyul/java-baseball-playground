package baseball;

import java.util.Scanner;

public class ResultView {

    private final Scanner scanner;
    private final Validator validator;

    public ResultView(Scanner scanner) {
        this.scanner = scanner;
        validator = new Validator();
    }

    public int correct() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.next();
        return validator.validateForResultView(input);
    }
}
