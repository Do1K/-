package baseball;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Comparator {

    private static final int MIN=0;
    private static final int MAX=9;
    private static final int MAX_DIGIT=3;
    private int[] result=new int[2];



    public int[] compare(ArrayList<Integer> answer, ArrayList<Integer> userAnswer){
        Stream<Integer> stream=answer.stream();
        for(int i=MIN;i<MAX_DIGIT;i++){
            if(answer.get(i)==userAnswer.get(i)){
                result[0]++;
            }else{
                if(userAnswer.contains(answer.get(i))){
                    result[1]++;
                }
            }
        }
        return result;


    }
}
