package baseball;

public class Verifier {

    private final RoundResult result;
    private final int[] correctValues = new int[3];
    private final int[] userValues = new int[3];

    public Verifier() {
        result = new RoundResult();
    }

    public RoundResult verify(CorrectAnswer correctAnswer, UserAnswer userAnswer) {
        init(correctAnswer, userAnswer);

        for (int i = 0; i < correctValues.length; i++) {
            verifyUserValues(i);
        }

        return result;
    }

    private void verifyUserValues(int i) {
        for (int j = 0; j < userValues.length; j++) {
            verifyEqual(i, j);
        }
    }

    private void verifyEqual(int i, int j) {
        if (correctValues[i] == userValues[j]) {
            addStrikeOrBall(i, j);
        }
    }

    private void addStrikeOrBall(int i, int j) {
        if (i == j) {
            result.addOneStrike();
            return;
        }
        result.addOneBall();
    }

    private void init(CorrectAnswer correctAnswer, UserAnswer userAnswer) {
        result.init();
        for (int i = 0; i < 3; i++) {
            correctValues[i] = correctAnswer.getValue()[i];
            userValues[i] = userAnswer.getValue()[i];
        }
    }
}
