package baseball;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Comparator {

    private static final int MIN=0;
    private static final int MAX_DIGIT=3;
    private int strike=0;
    private int ball=0;



    public int[] compare(ArrayList<Integer> answer, ArrayList<Integer> userAnswer){
        //Stream<Integer> stream=answer.stream();

        for(int i=MIN;i<MAX_DIGIT;i++){
            if(userAnswer.get(i).equals(answer.get(i))){
                strike++;
            }else{
                if(answer.contains(userAnswer.get(i))){
                    ball++;
                }
            }
        }
        return new int[]{strike,ball};


    }
}
