package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomMachine {

    private static final int MIN=0;
    private static final int MAX=9;
    private static final int MAX_DIGIT=3;
    private List<Integer> tempAnswer = new ArrayList<>();


    Balls answer;
    public Balls createRandomAnswer(){
        int i=0;
        while(i<MAX_DIGIT){
            int number=pickNumberInRange(MIN,MAX);
            if(!tempAnswer.contains(number)){
                tempAnswer.add(number);
                i++;
            }

        }
        answer=new Balls((ArrayList<Integer>) tempAnswer);

        return answer;
    }
}
