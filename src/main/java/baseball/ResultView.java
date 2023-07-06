package baseball;

public class ResultView {

    public void printResult(RoundResult result) {
        Integer strike = result.getStrike();
        Integer ball = result.getBall();
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        } else if (strike == 0) {
            System.out.println(ball + "볼");
            return;
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
