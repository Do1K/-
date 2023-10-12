package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private static final int MIN=0;
    private static final int MAX_BALLS=3;
    private static final int TO_DIVIDE=10;

    private String initUserAnswer;
    private List<Integer> userAnswer=new ArrayList<>();

    public  void answerInput(BaseballGame baseballGame){

        Balls balls;
        initUserAnswer= Console.readLine();
        addAnswerToList(reverseString(initUserAnswer));
        balls = validateBalls((ArrayList<Integer>) userAnswer);
        sendUserAnswer(balls,baseballGame);

    }

    public String reverseString(String initUserAnswer){
        StringBuffer sb = new StringBuffer(initUserAnswer);
        String strUserAnswer=sb.reverse().toString();
        return strUserAnswer;
    }

    public void addAnswerToList(String strUserAnswer){
        Integer intUserAnswer=Integer.parseInt(strUserAnswer);
        for(int i=MIN;i<strUserAnswer.length();i++){
            int remain=intUserAnswer%TO_DIVIDE;
            userAnswer.add(remain);
            intUserAnswer=intUserAnswer/TO_DIVIDE;
        }

    }

    public Balls validateBalls(ArrayList<Integer> userAnswer) {
        return new Balls(userAnswer);
    }

    public void sendUserAnswer(Balls balls, BaseballGame baseballGame) {
        baseballGame.receiveUserAnswer(balls);
    }

}
