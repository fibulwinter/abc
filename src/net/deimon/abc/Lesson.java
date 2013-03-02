package net.deimon.abc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: deimon
 * Date: 4/8/12
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Lesson {
    private static final int LAST_LEN=6;
    private List<Memorable> memorables=new ArrayList<Memorable>();
    private List<Memorable> future=new ArrayList<Memorable>();

    public Lesson(String... values){
        for(String s:values){
            memorables.add(new Memorable(s));
        }
        for(int i=0;i<16;i++){
            future.add(null);
        }
    }

    public List<Memorable> getMemorables() {
        return memorables;
    }

    public Memorable next(Memorable previous){
        Memorable last = future.remove(0);
        future.add(null);
        if(last!=null){
            int d=last.lastSucceed();
            for(int i=d-1;i<future.size();i++){
                if(future.get(i)==null){
                    if(i-1>0 && future.get(i-1)==last){
                        continue;
                    }
                    if(i+1<future.size() && future.get(i+1)==last){
                        continue;
                    }
                    future.set(i,last);
                    break;
                }
            }
        }
        if(future.get(0)==null){
            future.set(0,memorables.get((int) (Math.random()*memorables.size())));
//            Memorable best=null;
//            float sumErrorRate=0;
//            for(Memorable memorable:memorables){
//                if(best==null){
//                    best=memorable;
//                }
//                if(previous==memorable)continue;
//                float errorRate = memorable.errorRate();
//                float weight=1f+2f*Collections.frequency(last,memorable);
//                float weightedErrorRate = errorRate*weight;
//                sumErrorRate+=weightedErrorRate;
//                if(Math.random()<weightedErrorRate/sumErrorRate){
//                    best=memorable;
//                }
//            }
        }
        return future.get(0);
    }
}
