package baseball;

public class Display {

    public void printAllStrike(Score score){
        printBoard(score);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printBoard(Score score){
        int strike=score.getScore().get("strike");
        int ball=score.getScore().get("ball");
        if(strike!=0 && ball!=0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return;
        }
        if(strike!=0 && ball==0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        if(strike==0 && ball!=0) {
            System.out.println(ball + "볼");
            return;
        }
        if(strike==0 && ball==0){
            System.out.println("낫싱");
            return;
        }
    }
}
