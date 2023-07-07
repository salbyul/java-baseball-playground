package baseball;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final Validator validator;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
        validator = new Validator();
    }

    public void printInputNumber() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public Integer getInputUserNumber() {
        String input = getInput();
        return validator.validateForInputView(input);
    }

    private String getInput() {
        return scanner.nextLine();
    }
}
