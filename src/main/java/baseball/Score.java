package baseball;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private static final int MAX_STRIKE=3;
    private Map<String,Integer> scoreBoard=new HashMap<>();

    private boolean isAllStrike=false;

    private void setInitState(){
        scoreBoard.clear();
    }

    public boolean getIsAllStrike(){
        return isAllStrike;
    }
    public void recordScore(Integer strike, Integer ball){
        setInitState();
        scoreBoard.put("strike", strike);
        scoreBoard.put("ball",ball);
    }

    public HashMap<String,Integer> getScore(){
        return (HashMap<String, Integer>) scoreBoard;
    }

    public boolean judgeAllStrike(){
        if(scoreBoard.get("strike").equals(MAX_STRIKE)){
            isAllStrike=true;
            return true;
        }
        return false;
    }

}
