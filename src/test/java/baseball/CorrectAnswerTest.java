package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CorrectAnswerTest {

    @Test
    @DisplayName("랜덤한 숫자 3개가 나오는지")
    void correctAnswer() {
        Integer firstNumber;
        Integer secondNumber;
        Integer thirdNumber;
        int randomNumber = (int) (Math.random() * 10);
        firstNumber = randomNumber;
        while (randomNumber == firstNumber) {
            randomNumber = (int) (Math.random() * 10);
        }
        secondNumber = randomNumber;
        while (randomNumber == firstNumber || randomNumber == secondNumber) {
            randomNumber = (int) (Math.random() * 10);
        }
        thirdNumber = randomNumber;

        assertThat(firstNumber).isNotEqualTo(secondNumber);
        assertThat(firstNumber).isNotEqualTo(thirdNumber);
        assertThat(secondNumber).isNotEqualTo(thirdNumber);
    }
}
