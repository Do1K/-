package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BaseballGame {

    private static final int COMPLETE=3;
    private static final int STRIKE=0;
    private static final int BALL=0;
    private List<Integer> answer=new ArrayList<>();

    private List<Integer> userAnswer=new ArrayList<>();
    private int[] result=new int[2];
    private int strike;
    private int ball;

    private boolean isCorrect=false;

    private static BaseballGame baseballGame;

    public BaseballGame(List<Integer> answer) {
        this.answer = answer;
    }

    public static BaseballGame start(){

        RandomMachine randomMachine=new RandomMachine();
        baseballGame=new BaseballGame(randomMachine.createRandomAnswer());

        return baseballGame;
    }

    public void receiveUserAnswer(ArrayList<Integer> userAnswer){
        this.userAnswer.clear();
        Stream<Integer> stream=userAnswer.stream();
        stream.forEach(number->this.userAnswer.add(number));

        result=callComparator(userAnswer);
        strike = result[0];
        ball = result[1];
        judgeStrike();

    }

    private int[] callComparator(ArrayList<Integer> userAnswer){
        Comparator comparator=new Comparator();
        return comparator.compare((ArrayList<Integer>) answer,userAnswer);
    }

    private void judgeStrike(){
        if(strike==COMPLETE){
            printBoard();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isCorrect=true;
            return;
        }
        printBoard();

    }

    private void printBoard(){
        if(result[STRIKE]!=0 && result[BALL]!=0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
            return;
        }else if(result[STRIKE]!=0 && result[BALL]==0){
            System.out.println(strike+"스트라이크");
            return;
        }
        System.out.println(ball+"볼");
    }

    public boolean isCorrect(){
        return isCorrect;
    }
    public static boolean reStart(){
        System.out.println("게임을 새로 시작할려면 1, 종료하려면 2를 입력하세요.");
        String strCommand= Console.readLine();
        if(strCommand.equals("1")){
            return true;
        }else if(strCommand.equals("2")){
            return false;
        }
        throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
    }




}
