package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    Judgement judgement;

    @BeforeEach
    void setUp() {
        judgement = new Judgement();
    }

    @Test
    @DisplayName("숫자와 위치가 일치하면 스트라이크")
    void strike() {
        Ball computerBall = new Ball(1, 1);
        Ball userBall = new Ball(1, 1);
        BallStatus status = Ball.compare(computerBall, userBall);
        assertThat(status.isStrike()).isTrue();
    }

    @Test
    @DisplayName("숫자만 일치하면 볼")
    void ball() {
        Ball computerBall = new Ball(1, 1);
        Ball userBall = new Ball(2, 1);
        BallStatus status = Ball.compare(computerBall, userBall);
        assertThat(status.isBall()).isTrue();
    }

    @Test
    @DisplayName("일치하는 숫자가 없다면 아웃")
    void out() {
        Ball computerBall = new Ball(1, 1);
        Ball userBall = new Ball(1, 2);
        BallStatus status = Ball.compare(computerBall, userBall);
        assertThat(status.isOut()).isTrue();
    }

    @Test
    @DisplayName("숫자 3개 의 값과 위치가 다를 경우 아웃")
    void out3() {
        Ball computerBallOne = new Ball(1, 4);
        Ball computerBallTwo = new Ball(2, 5);
        Ball computerBallThree = new Ball(3, 6);
        List<Ball> computerBalls = new ArrayList<>();
        computerBalls.add(computerBallOne);
        computerBalls.add(computerBallTwo);
        computerBalls.add(computerBallThree);

        Ball ballOne = new Ball(1, 1);
        Ball ballTwo = new Ball(2, 2);
        Ball ballThree = new Ball(3, 3);
        List<Ball> userBalls = new ArrayList<>();
        userBalls.add(ballOne);
        userBalls.add(ballTwo);
        userBalls.add(ballThree);

        JudgeResult result = judgement.judge(computerBalls, userBalls);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("1스트라이크")
    void strike1() {
        Ball computerBallOne = new Ball(1, 1);
        Ball computerBallTwo = new Ball(2, 5);
        Ball computerBallThree = new Ball(3, 6);
        List<Ball> computerBalls = new ArrayList<>();
        computerBalls.add(computerBallOne);
        computerBalls.add(computerBallTwo);
        computerBalls.add(computerBallThree);

        Ball ballOne = new Ball(1, 1);
        Ball ballTwo = new Ball(2, 2);
        Ball ballThree = new Ball(3, 3);
        List<Ball> userBalls = new ArrayList<>();
        userBalls.add(ballOne);
        userBalls.add(ballTwo);
        userBalls.add(ballThree);

        JudgeResult result = judgement.judge(computerBalls, userBalls);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("1볼")
    void ball1() {
        Ball computerBallOne = new Ball(2, 1);
        Ball computerBallTwo = new Ball(1, 5);
        Ball computerBallThree = new Ball(3, 6);
        List<Ball> computerBalls = new ArrayList<>();
        computerBalls.add(computerBallOne);
        computerBalls.add(computerBallTwo);
        computerBalls.add(computerBallThree);

        Ball ballOne = new Ball(1, 1);
        Ball ballTwo = new Ball(2, 2);
        Ball ballThree = new Ball(3, 3);
        List<Ball> userBalls = new ArrayList<>();
        userBalls.add(ballOne);
        userBalls.add(ballTwo);
        userBalls.add(ballThree);

        JudgeResult result = judgement.judge(computerBalls, userBalls);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("1볼 1스트라이크")
    void strike1Ball1() {
        Ball computerBallOne = new Ball(1, 1);
        Ball computerBallTwo = new Ball(3, 2);
        Ball computerBallThree = new Ball(2, 6);
        List<Ball> computerBalls = new ArrayList<>();
        computerBalls.add(computerBallOne);
        computerBalls.add(computerBallTwo);
        computerBalls.add(computerBallThree);

        Ball ballOne = new Ball(1, 1);
        Ball ballTwo = new Ball(2, 2);
        Ball ballThree = new Ball(3, 3);
        List<Ball> userBalls = new ArrayList<>();
        userBalls.add(ballOne);
        userBalls.add(ballTwo);
        userBalls.add(ballThree);

        JudgeResult result = judgement.judge(computerBalls, userBalls);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("3스트라이크")
    void strike3() {
        Ball computerBallOne = new Ball(1, 1);
        Ball computerBallTwo = new Ball(2, 2);
        Ball computerBallThree = new Ball(3, 3);
        List<Ball> computerBalls = new ArrayList<>();
        computerBalls.add(computerBallOne);
        computerBalls.add(computerBallTwo);
        computerBalls.add(computerBallThree);

        Ball ballOne = new Ball(1, 1);
        Ball ballTwo = new Ball(2, 2);
        Ball ballThree = new Ball(3, 3);
        List<Ball> userBalls = new ArrayList<>();
        userBalls.add(ballOne);
        userBalls.add(ballTwo);
        userBalls.add(ballThree);

        JudgeResult result = judgement.judge(computerBalls, userBalls);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }
}
