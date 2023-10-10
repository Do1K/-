package baseball;



public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        do{
            run();
        }while(BaseballGame.reStart());

    }



    public static void run(){
        BaseballGame baseballGame=BaseballGame.start();
        do{
            System.out.println("숫자를 입력해주세요: ");
            User user=new User();


            user.answerInput(baseballGame);

        }while(!baseballGame.isCorrect());
    }

}
