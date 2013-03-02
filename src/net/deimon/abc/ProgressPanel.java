package net.deimon.abc;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: deimon
 * Date: 4/8/12
 * Time: 8:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProgressPanel {
    public static final int MAX_COLS = 5;
    private List<Memorable> memorables;
    private JPanel root;
    private Map<Memorable, JLabel> labels=new HashMap<Memorable, JLabel>();
    private Map<Memorable, Float> best=new HashMap<Memorable, Float>();

    public ProgressPanel(List<Memorable> memorables) {
        this.memorables = memorables;
        root = new JPanel(new GridLayout(memorables.size()/ MAX_COLS +1, Math.min(MAX_COLS, memorables.size())));
        root.setBackground(Color.BLACK);
        for (int i = 0, memorablesSize = memorables.size(); i < memorablesSize; i++) {
            Memorable memorable = memorables.get(i);
            JLabel label = new JLabel(memorable.getValue());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            labels.put(memorable, label);
            root.add(label);
        }
    }

    public void update(){
        for(Map.Entry<Memorable,JLabel> entry:labels.entrySet()){
            Memorable memorable = entry.getKey();
            float hp = memorable.hasHistory();
            Color color=new Color(hp,hp,hp);
            if(hp==1){
                boolean wasBetter=false;
                float er=memorable.errorRate();
                if(best.containsKey(memorable)){
                    wasBetter=er> best.get(memorable);
                    er=Math.min(er, best.get(memorable));
                }
                best.put(memorable,er);
                if(wasBetter){
                    if(er<0.3){
                        color = new Color(0,128,0);
                    }else if(er>0.7){
                        color = new Color(128,0, 0);
                    }else{
                        color = new Color(128,128,0);
                    }
                }else{
                    if(er<0.3){
                        color = Color.GREEN;
                    }else if(er>0.7){
                        color = Color.RED;
                    }else{
                        color=Color.YELLOW;
                    }
                }
            }
            entry.getValue().setForeground(color);
        }
        root.repaint();
    }

    public JPanel getRoot() {
        return root;
    }
}
