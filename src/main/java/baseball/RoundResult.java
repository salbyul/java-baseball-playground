package baseball;

public class RoundResult {

    private Integer strike;
    private Integer ball;

    public void addOneStrike() {
        strike++;
    }

    public void addOneBall() {
        ball++;
    }

    public void init() {
        strike = 0;
        ball = 0;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }
}
