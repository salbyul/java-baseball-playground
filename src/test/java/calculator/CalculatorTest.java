package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("덧셈 검증")
    void add() {
        int result = calculator.add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 검증")
    void subtract() {
        int result = calculator.subtract(10, 9);
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈 검증")
    void multiply() {
        int result = calculator.multiply(2, 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 검증")
    void divide() {
        int result = calculator.divide(20, 10);
        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("계산이 제대로 되는 지")
    @CsvSource(value = {"2 + 3 * 4 / 2:10"}, delimiter = ':')
    void calculate(String input, int correct) {
        InputStream inputStream = generateUserInput(input);
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        int result = calculator.calculate(scanner.nextLine());
        assertThat(result).isEqualTo(correct);
    }

    InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
    }
}
