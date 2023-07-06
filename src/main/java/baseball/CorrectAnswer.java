package baseball;

public class CorrectAnswer {

    private final int[] value = new int[3];

    public CorrectAnswer() {
        int randomNumber = (int) (Math.random() * 10);
        value[0] = randomNumber;
        while (randomNumber == value[0]) {
            randomNumber = (int) (Math.random() * 10);
        }
        value[1] = randomNumber;
        while (randomNumber == value[0] || randomNumber == value[1]) {
            randomNumber = (int) (Math.random() * 10);
        }
        value[2] = randomNumber;
    }

    public int[] getValue() {
        return value;
    }
}
