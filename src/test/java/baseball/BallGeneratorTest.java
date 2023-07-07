package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BallGeneratorTest {

    Generator generator;

    @BeforeEach
    void setUp() {
        generator = new Generator();
    }

    @Test
    @DisplayName("랜덤한 1 ~ 9 숫자 생성")
    void generateRandomNumber() {
        int number = generator.generateRandomNumber();
        assertThat(number).isBetween(1, 9);
    }

    @ParameterizedTest
    @DisplayName("숫자와 위치를 가진 볼 생성")
    @ValueSource(ints = {1, 2, 3})
    void generateBall(int index) {
        Ball ball = generator.generateBall(index);
        assertThat(ball.getPosition()).isBetween(1, 3);
        assertThat(ball.getValue()).isBetween(1, 9);
    }

    @Test
    @DisplayName("중복되지 않는 볼 3개 생성")
    void generateBalls() {
        List<Ball> balls = generator.generateBalls();
        assertThat(balls).size().isEqualTo(3);
        assertThat(balls.get(0).getValue()).isNotEqualTo(balls.get(1).getValue());
        assertThat(balls.get(0).getValue()).isNotEqualTo(balls.get(2).getValue());
        assertThat(balls.get(1).getValue()).isNotEqualTo(balls.get(2).getValue());
    }
}
