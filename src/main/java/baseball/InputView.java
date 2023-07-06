package baseball;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public int getInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        int input = scanner.nextInt();
        System.out.println();
        return input;
    }
}
