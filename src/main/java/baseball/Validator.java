package baseball;

public class Validator {

    public int validateForInputView(String input) {
        int number = validateNumber(input);
        validateThreeNumber(number);
        validateContainZero(number);
        validateDuplicatedNumber(number);
        return number;
    }

    public int validateNumber(String input) {
        return Integer.parseInt(input);
    }

    public void validateThreeNumber(int input) {
        if (input < 100 || input > 999) {
            throw new IllegalArgumentException("숫자는 3자리이어야 합니다.");
        }
    }

    public void validateContainZero(int input) {
        while (input != 0) {
            if (input % 10 == 0) {
                throw new IllegalArgumentException("숫자에 0이 포함될 수 없습니다.");
            }
            input /= 10;
        }
    }

    public void validateDuplicatedNumber(int input) {
        String stringInput = String.valueOf(input);

        for (int i = 0; i < 3; i++) {
            char preLetter = stringInput.charAt(i);
            checkExtra(stringInput, i, preLetter);
        }
    }

    private void checkExtra(String stringInput, int i, char preLetter) {
        for (int j = i + 1; j < 3; j++) {
            char currentLetter = stringInput.charAt(j);
            validateDuplicated(preLetter, currentLetter);
        }
    }

    private void validateDuplicated(char preLetter, char currentLetter) {
        if (preLetter == currentLetter) {
            throw new IllegalArgumentException("같은 숫자가 포함될 수 없습니다.");
        }
    }

    public void validateOneOrTwo(int input) {
        if (input != 1 && input != 2) {
            throw new IllegalArgumentException("1과 2만 입력할 수 있습니다.");
        }
    }

    public int validateForResultView(String input) {
        int number = validateNumber(input);
        validateOneOrTwo(number);
        return number;
    }
}
