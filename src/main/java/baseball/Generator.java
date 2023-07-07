package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Generator {

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(8) + 1;
    }

    public Ball generateBall(int position) {
        int number = generateRandomNumber();
        return new Ball(position, number);
    }

    public List<Ball> generateBalls() {
        List<Ball> list = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            addBall(list, i);
        }
        return list;
    }

    private void addBall(List<Ball> list, int position) {
        while (canAdd(list, position)) {
            Ball ball = generateBall(position);
            boolean isExist = isExist(ball, list);
            add(list, ball, isExist);
        }
    }

    private boolean canAdd(List<Ball> list, int position) {
        return list.size() != position;
    }

    private void add(List<Ball> list, Ball ball, boolean isExist) {
        if (!isExist) {
            list.add(ball);
        }
    }

    private boolean isExist(Ball ball, List<Ball> list) {
        Optional<Integer> first = list.stream()
                .map(Ball::getValue)
                .filter(value -> value == ball.getValue())
                .findFirst();
        return first.isPresent();
    }
}
