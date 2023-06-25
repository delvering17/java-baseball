package baseball.domain;

import baseball.common.GameConst;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.common.GameConst.*;

public class Computer {

    private List<Integer> number;

    public List<Integer> getNumber() {
        return number;
    }

    public void settingNumber() {
        this.number = initNumbers();
        for (Integer integer : number) {
            System.out.print(integer);
        }
        System.out.println();
    }

    public List<Integer> initNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < GAME_NUMBER_LENGTH) {
            int pickedNumber = Randoms.pickNumberInRange(GAME_NUMBER_RANGE_START, GAME_NUMBER_RANGE_END);
            if (numbers.contains(pickedNumber)) continue;
            numbers.add(pickedNumber);
        }
        return numbers;
    }


}
