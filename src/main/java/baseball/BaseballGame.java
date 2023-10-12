package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BaseballGame {

    private static final int COMPLETE=3;
    private static final int STRIKE=0;
    private static final int BALL=1;
    private static Balls answer;

    //private Balls userAnswer;
    private Score score;



    //베이스볼 게임을 진행하는 주체(게임기?)는 (객체)하나만 있어도 된다. 싱글톤 패턴 이용
    private static BaseballGame baseballGame=new BaseballGame();
    Display display=new Display();

    private BaseballGame() {}

    public static BaseballGame getBaseballGame(){
        return baseballGame;
    }

    public void setAnswer(Balls answer){
        this.answer=answer;
    }

    public static void start(){

        RandomMachine randomMachine=new RandomMachine();
        baseballGame.setAnswer(randomMachine.createRandomAnswer());

    }

    public Score getScore(){
        return score;
    }

    public void receiveUserAnswer(Balls userAnswer){

        callComparator(answer, userAnswer);
        judgeStrike();

    }

    private void callComparator(Balls answer,Balls userAnswer){
        Comparator comparator=new Comparator();
        score=comparator.compare(answer,userAnswer);
        System.out.println(score.getScore().get("strike"));
        System.out.println(score.getScore().get("ball"));


    }

    private void judgeStrike(){
        if(score.judgeAllStrike()){
            display.printAllStrike(score);


        }
        else{
            display.printBoard(score);
        }
    }



    public static boolean reStart(){
        System.out.println("게임을 새로 시작할려면 1, 종료하려면 2를 입력하세요.");
        String strCommand= Console.readLine();
        if(strCommand.equals("1")){
            return true;
        }else if(strCommand.equals("2")){
            return false;
        }
        throw new IllegalArgumentException();
    }

}
