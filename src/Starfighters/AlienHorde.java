package Starfighters;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;
        private int stuff;
        private int hordeSize;
	public AlienHorde(int size)
	{
            aliens = new ArrayList<Alien>();
            hordeSize = size;
	}

	public void add(Alien al)
	{
            aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
            for (Alien a: aliens){
                a.draw(window);
            }
	}

	public void moveEmAll()
	{
            stuff++;
            for (Alien a: aliens){
                if (stuff < 100){
                    a.move("RIGHT");
                }
                else if (stuff < 200){
                    a.move("DOWN");
                }
                else if (stuff < 300){
                    a.move("UP");
                    
                }
                else if (stuff < 400){
                    a.move("LEFT");
                }
                else if (stuff < 600){
                    stuff = 0;
                }
            }
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
            for (Alien a: aliens){
                for (Ammo s: shots){
                    if (a.isCollide(s)){
                        shots.remove(s);
                        aliens.remove(a);
                        
                    }
                }
            }
	}
        
        public void checkShipDeath(Ship s)
	{
		for (int i = 0; i < aliens.size(); i++)
		{
			if (s.isCollide(aliens.get(i)))
			{
				System.out.println("You lose. You killed " + (hordeSize - aliens.size()) + " aliens.");
				System.exit(0);
			}
		}
	}
        
        public int getSize(){
            return aliens.size();
        }
	public String toString()
	{
		return "";
	}
}
