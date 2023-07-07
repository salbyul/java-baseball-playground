package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @ParameterizedTest
    @DisplayName("유저가 입력한 값이 숫자인지")
    @ValueSource(strings = "This is English")
    void validateNumber(String input) {
        InputView inputView = new InputView(new Scanner(System.in));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNumber(input);
        });
        assertThat(exception).isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @DisplayName("유저가 입력한 숫자가 3자리인지")
    @ValueSource(ints = {26, 1})
    void validateThreeNumber(int input) {
        InputView inputView = new InputView(new Scanner(System.in));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateThreeNumber(input);
        });
        assertThat(exception.getMessage()).isEqualTo("숫자는 3자리이어야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("유저가 입력한 숫자 중 0이 포함되었는지")
    @ValueSource(ints = {140, 805})
    void validateZeroInput(int input) {
        InputView inputView = new InputView(new Scanner(System.in));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateContainZero(input);

        });
        assertThat(exception.getMessage()).isEqualTo("숫자에 0이 포함될 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("유저가 입력한 숫자 중 중복된 숫자가 있는지")
    @ValueSource(ints = {112, 644})
    void validateDuplicatedNumber(int input) {
        InputView inputView = new InputView(new Scanner(System.in));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateDuplicatedNumber(input);
        });
        assertThat(exception.getMessage()).isEqualTo("같은 숫자가 포함될 수 없습니다.");
    }
}
