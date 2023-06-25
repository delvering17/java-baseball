package baseball.service;

import baseball.common.GameConst;
import baseball.domain.GameResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GameCalculator {

    public GameResult calculator(String input, List<Integer> computer) {
        int[] user = Stream.of(input.split("")).mapToInt(Integer::parseInt).toArray();

        int ball = 0;
        int strike = 0;

        for (int i = 0; i < GameConst.GAME_NUMBER_LENGTH; i++) {
            int num = user[i];

            if (computer.get(i) == num) {
                strike++;
            } else if (computer.contains(num)) {
                ball++;
            }
        }

        return new GameResult(ball, strike);
    }

    public boolean isGameEnd(GameResult result) {
        return result.getStrike() == GameConst.GAME_NUMBER_LENGTH;
    }

}
