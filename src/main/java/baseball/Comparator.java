package baseball;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Comparator {

    private static final int MIN=0;
    private static final int MAX_DIGIT=3;

    private ArrayList<Integer> answer;
    private ArrayList<Integer> userAnswer;


    public Score compare(Balls answer, Balls userAnswer){

        int strike=0;
        int ball=0;
        this.answer=answer.getBalls();
        this.userAnswer=userAnswer.getBalls();

        for(int i=MIN;i<MAX_DIGIT;i++){
            if(this.userAnswer.get(i).equals(this.answer.get(i))) {
                strike++;
                continue;
            }
            if(this.answer.contains(this.userAnswer.get(i))){
                ball++;
            }

        }

        return writeScore(strike,ball);
    }

    public Score writeScore(Integer strike, Integer ball) {
        Score score = new Score();
        score.recordScore(strike, ball);
        return score;
    }
}
