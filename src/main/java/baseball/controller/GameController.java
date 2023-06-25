package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    public void play() {
        Game game = new Game();
        do {
            game.startGame();
        } while (askRestartGame());
    }

    public boolean askRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return input.equals("1");
    }

}
