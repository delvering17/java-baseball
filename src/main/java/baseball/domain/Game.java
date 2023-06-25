package baseball.domain;

import baseball.common.GameConst;
import baseball.service.GameCalculator;
import baseball.service.GameInitializer;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Computer computer;
    private User user;

    private GameCalculator calculator = new GameCalculator();

    public void startGame() {
        System.out.println("=====");
        System.out.println("숫자 야구 게임을 시작합니다.");
        setUp();

        while(true) {
            GameResult result = throwNumber();
            resultMessage(result);
            if (calculator.isGameEnd(result)) break;
        }
    }

    public void setUp() {
        this.computer = GameInitializer.initComputer();
        this.user = GameInitializer.initUser();
    }

    public GameResult throwNumber() {
        GameResult result = calculator.calculator(userInput(), computer.getNumber());
        return result;
    }

    public void resultMessage(GameResult result) {
        StringBuilder messageBuilder = new StringBuilder();
        if (result.getBall() > 0) {
            messageBuilder.append(result.getBall() + "볼 ");
        }
        if (result.getStrike() > 0) {
            messageBuilder.append(result.getStrike() + "스트라이크 ");
        }
        if (result.getStrike() == GameConst.GAME_NUMBER_LENGTH) {
            messageBuilder.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (result.getBall() + result.getStrike() == 0) {
            messageBuilder.append("낫싱");
        }
        System.out.println(messageBuilder);
    }

    public String userInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }


}
