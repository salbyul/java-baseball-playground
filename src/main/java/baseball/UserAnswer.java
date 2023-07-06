package baseball;

public class UserAnswer {

    private final Integer firstNumber;
    private final Integer secondNumber;
    private final Integer thirdNumber;

    public UserAnswer(Integer firstNumber, Integer secondNumber, Integer thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public Integer getSecondNumber() {
        return secondNumber;
    }

    public Integer getThirdNumber() {
        return thirdNumber;
    }
}
