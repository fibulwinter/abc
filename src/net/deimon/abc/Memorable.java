package net.deimon.abc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: deimon
 * Date: 4/8/12
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Memorable {
    private String value;
    private static int HISTORY_WINDOW=5;
    private List<Boolean> attempts=new ArrayList<Boolean>(HISTORY_WINDOW);

    public Memorable(String value) {
        this.value = value;
    }

    public void attempt(boolean succeed){
        attempts.add(succeed);
        if(attempts.size()>HISTORY_WINDOW){
            attempts.remove(0);
        }
    }

    public String getValue() {
        return value;
    }

    public int lastSucceed(){
        int i=2;
        for(int j=attempts.size()-1;j>=0;j--){
            if(attempts.get(j)){
                i*=2;
            }else{
                return i;
            }
        }
        return i;
    }

    public int getGood() {
        return count(true);
    }

    @Override
    public String toString() {
        return value;
    }

    private int count(boolean target) {
        int good=0;
        for(Boolean b:attempts){
            if(b.equals(target)){
                good++;
            }
        }
        return good;
    }

    public int getBad() {
        return count(false);
    }

    public float errorRate(){
        if(hasHistory()<1f){
            return 0.5f;
        }
        return Math.max(0.1f,(1.0f*getBad())/(getGood()+getBad()));
    }

    public float hasHistory() {
        return Math.min(1f,(getGood()+getBad())/4.0f);
    }
}
