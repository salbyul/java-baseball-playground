package baseball;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public int getUserValues() {
        System.out.print("숫자를 입력해 주세요 : ");
        int input = scanner.nextInt();
        System.out.println();
        return input;
    }

    public boolean getUserReplay() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = scanner.nextInt();
        if (input == 2) {
            scanner.close();
            return false;
        }
        return true;
    }

}
