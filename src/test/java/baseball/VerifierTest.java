package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class VerifierTest {

    @Test
    @DisplayName("정답과 입력값을 검사할 수 있는지")
    void verify() {
        MockCorrectAnswer mockCorrectAnswer = new MockCorrectAnswer(6, 2, 1);
        UserAnswer userAnswer = new UserAnswer(1, 2, 3);
        Verifier verifier = new Verifier();
        RoundResult result = verifier.verify(mockCorrectAnswer, userAnswer);

        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    public static class MockCorrectAnswer extends CorrectAnswer{

        private final int[] value = new int[3];

        public MockCorrectAnswer(int first, int second, int third) {
            value[0] = first;
            value[1] = second;
            value[2] = third;
        }

        public int[] getValue() {
            return value;
        }
    }
}
