package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InputViewTest {

    private static ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream(); // outputStream 생성
        System.setOut(new PrintStream(outputStream)); // 생성한 outputStream으로 설정
    }

    @Test
    @DisplayName("'숫자를 입력해주세요: ' 출력")
    void printInputNumber() {
        InputView inputView = new InputView();
        inputView.printInputNumber();
        Assertions.assertThat("숫자를 입력해주세요: ").isEqualTo(outputStream.toString());
    }
}
