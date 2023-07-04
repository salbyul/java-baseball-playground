package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String firstCase = "1,2";
        String[] firstSplit = firstCase.split(",");
        assertThat(firstSplit).contains("1", "2");
        String secondCase = "1";
        String[] secondSplit = secondCase.split(",");
        assertThat(secondSplit).containsExactly("1");
    }

    @Test
    void substring() {
        String value = "(1,2)";
        String substring = value.substring(1, value.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드 테스트")
    void charAt() {
        String value = "abc";
        char c = value.charAt(1);
        assertThat(c).isEqualTo('b');

        assertThatThrownBy(() -> {
            value.charAt(10);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
