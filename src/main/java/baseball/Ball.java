package baseball;

import java.util.Objects;

public class Ball {

    private int position;
    private int value;

    public Ball(int position, int value) {
        this.position = position;
        this.value = value;
    }

    public int getPosition() {
        return this.position;
    }

    public int getValue() {
        return this.value;
    }

    public static BallStatus compare(Ball ball, Ball target) {
        if (ball.equals(target)) {
            return BallStatus.STRIKE;
        }
        if (ball.value == target.value) {
            return BallStatus.BALL;
        }
        return BallStatus.OUT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return getPosition() == ball.getPosition() && getValue() == ball.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition(), getValue());
    }
}
