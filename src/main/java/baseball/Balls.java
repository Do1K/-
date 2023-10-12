package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    private static final int BALLS_SIZE = 3;
    private final ArrayList<Integer> balls;

    public Balls(ArrayList<Integer> balls){
        validateSize(balls);
        validateDuplicated(balls);
        this.balls=balls;
    }

    public void validateSize(List<Integer> balls){
        if(balls.size()!=BALLS_SIZE){
            throw new IllegalArgumentException("3개의 수를 입력해주세요.");
        }
    }

    public void validateDuplicated(List<Integer> balls){
        Set<Integer> nonDuplicatedNumbers=new HashSet<>(balls);
        if(nonDuplicatedNumbers.size()!=BALLS_SIZE){
            throw new IllegalArgumentException("중복되지 않은 수를 입력해주세요");
        }
    }

    public ArrayList<Integer> getBalls(){
        return balls;
    }


}
