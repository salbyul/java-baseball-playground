package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ResultViewTest {

    private static ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("유저가 정답을 맞춘 경우 출력이 나오는 지")
    void ifCorrect() {
        ResultView resultView = new ResultView(new Scanner(System.in));
        resultView.correct();
        assertThat("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.").isEqualTo(outputStream.toString());
    }

    @ParameterizedTest
    @DisplayName("게임 재시작 여부 1과 2가 아닐 경우")
    @ValueSource(ints = {3, 4, 6, 10})
    void getUserInput(int input) {
        Validator validator = new Validator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateOneOrTwo(input);
        });
        assertThat(exception.getMessage()).isEqualTo("1과 2만 입력할 수 있습니다.");
    }

}
