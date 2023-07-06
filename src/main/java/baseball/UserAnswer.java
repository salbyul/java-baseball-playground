package baseball;

public class UserAnswer {

    private final int[] value = new int[3];

    public UserAnswer(Integer firstNumber, Integer secondNumber, Integer thirdNumber) {
        value[0] = firstNumber;
        value[1] = secondNumber;
        value[2] = thirdNumber;
    }

    public int[] getValue() {
        return value;
    }
}
