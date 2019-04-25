/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinterScene;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
/**
 *
 * @author line8847
 */
public class StormySnowFlakes {
    public StormySnowFlakes(){
        
    }
    
    public void startStorm(List<AbstractShape> shapes, Graphics window){
        for (AbstractShape s: shapes){
            int offset = (int) (Math.random() * 4);
            int rnd = (int) (Math.random() * 2);
            if (rnd == 1) {
                offset = offset * -1;
            }
            if (s.getYPos() >= 500) {
                int y = (int) (Math.random() * 300);
                s.setYPos(y);
            }
            else if (s.getXPos() >= 700){
                int x = (int) (Math.random() * 200);
                s.setXPos(x);
            }
            else{
                s.setXPos(s.getXPos() + 20);
                s.setYPos(s.getYPos() +20);
            }
            
            s.draw(window);
        }
    }
}
