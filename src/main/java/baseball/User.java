package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private static final int MIN=0;
    private static final int MAX_DIGIT=3;
    private List<Integer> userAnswer=new ArrayList<>();

    public  boolean answerInput(BaseballGame baseballGame){

        String strAnswer= Console.readLine();
        StringBuffer sb = new StringBuffer(strAnswer);
        String reverseAnswer = sb.reverse().toString();
        if(strAnswer.length()==MAX_DIGIT){
            int intAnswer=Integer.parseInt(reverseAnswer);
            for(int i=MIN;i<MAX_DIGIT;i++){
                int remain=intAnswer%10;
                userAnswer.add(remain);
                intAnswer=intAnswer/10;
            }
            baseballGame.receiveUserAnswer((ArrayList<Integer>) userAnswer);
            userAnswer.clear();
            return true;
        }
        throw new IllegalArgumentException();

    }

}
