package baseball;

public class JudgeResult {

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void add(BallStatus status) {
        if (status.isStrike()) {
            strike++;
        } else if (status.isBall()) {
            ball++;
        }
    }
}
