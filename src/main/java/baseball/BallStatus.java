package baseball;

public enum BallStatus {
    STRIKE, OUT, BALL;

    public boolean isStrike() {
        return this.equals(STRIKE);
    }

    public boolean isBall() {
        return this.equals(BALL);
    }

    public boolean isOut() {
        return this.equals(OUT);
    }
}
