package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomMachine {

    private static final int MIN=0;
    private static final int MAX=9;
    private static final int MAX_DIGIT=3;
    private List<Integer> answer = new ArrayList<>();

    public List<Integer> createRandomAnswer(){
        for(int i=MIN; i<MAX_DIGIT;i++){
            answer.add(pickNumberInRange(MIN,MAX));
        }

        return answer;
    }
}
