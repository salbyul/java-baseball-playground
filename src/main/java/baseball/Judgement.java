package baseball;

import java.util.List;

public class Judgement {

    public JudgeResult judge(List<Ball> computerBalls, List<Ball> userBalls) {
        JudgeResult result = new JudgeResult();

        for (Ball computerBall : computerBalls) {
            judgeOne(userBalls, computerBall, result);
        }
        return result;
    }

    private void judgeOne(List<Ball> userBalls, Ball computerBall, JudgeResult result) {
        for (Ball userBall : userBalls) {
            BallStatus status = Ball.compare(computerBall, userBall);
            result.add(status);
        }
    }
}
