package Starfighters;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.*;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(10,10,10,10,10);
	}

	public Ship(int x, int y)
	{
	   //add code here
            this(x, y, 10, 10, 10);
	}

	public Ship(int x, int y, int s)
	{
	   //add code here
            this(x, y, 10, 10, s);
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			
			image = ImageIO.read(new FileInputStream("resources/ship.jpg"));
                        
		}
		catch(Exception e)
		{
			//feel free to do something here
                    System.out.println(e);
		}
	}


	public void setSpeed(int s)
	{
	   //add more code
            speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(String direction)
	{
		//add code here
            if (direction.equals("LEFT")){
                this.setX(this.getX()-speed);
            }
            else if (direction.equals("RIGHT")){
                this.setX(this.getX()+speed);
            }
            else if (direction.equals("UP")){
                this.setY(this.getY()-speed);
            }
            else{
                this.setY(this.getY() + speed);
            }
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
