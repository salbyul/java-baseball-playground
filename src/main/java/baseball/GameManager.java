package baseball;

public class GameManager {

    private CorrectAnswer correctAnswer;
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start() {
        init();
        UserAnswer userInput = getUserInput();
        Verifier verifier = new Verifier();
        while (!verifier.verify(correctAnswer, userInput)) {
            RoundResult result = verifier.getResult();
            resultView.printResult(result);
            userInput = getUserInput();
        }
        if (inputView.getUserReplay()) {
            start();
        }
    }

    private void init() {
        correctAnswer = new CorrectAnswer();
    }

    private UserAnswer getUserInput() {
        int input = inputView.getUserValues();

        int firstInput = input / 100;
        int secondInput = input % 100 / 10;
        int thirdInput = input % 10;

        return new UserAnswer(firstInput, secondInput, thirdInput);
    }

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.start();
    }
}
