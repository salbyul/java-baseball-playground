package baseball;

public class CorrectAnswer {

    private final Integer firstNumber;
    private final Integer secondNumber;
    private final Integer thirdNumber;

    public CorrectAnswer() {
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
    }
}
