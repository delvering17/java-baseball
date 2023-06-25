package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;

public class GameInitializer {

    public static Computer initComputer() {
        Computer computer = new Computer();
        computer.settingNumber();

        return computer;
    }

    public static User initUser() {
        return new User();
    }

}
