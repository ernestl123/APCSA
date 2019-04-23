package Snowman;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SnowMan extends AbstractShape
{
   public SnowMan(int x, int y, int w, int h )
   {
		super(x, y, w, h, Color.WHITE, 0, 0);
   }

   public void draw(Graphics window)
   {
      //add code here to make a snowman 
       window.fillOval(this.getXPos(), this.getYPos(), this.getWidth(), this.getHeight());
       window.fillOval(this.getXPos()-20, this.getYPos()+30, this.getWidth()+30, this.getHeight()+30);
       window.fillOval(this.getXPos()-40, this.getYPos()+60, this.getWidth()+50, this.getHeight()+50);
       
   }

   public void moveAndDraw(Graphics window)
   {
      draw(window);   
   }
}