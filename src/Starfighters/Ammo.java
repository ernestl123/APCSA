package Starfighters;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
		this(0,0,2);
	}

	public Ammo(int x, int y)
	{
		//add code
            this(x, y, 2);
	}

	public Ammo(int x, int y, int s)
	{
		//add code
            super(x, y, 10, 10);
            speed =s ;
            
	}

	public void setSpeed(int s)
	{
	   //add code
            speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		//add code to draw the ammo
            window.setColor(Color.YELLOW);
            window.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
	
	public void move( String direction )
	{
            if (direction.equals("UP")){
                setY(this.getY()-speed);
            }
	}

	public String toString()
	{
		return "";
	}
}
