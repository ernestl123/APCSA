package Starfighters;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private AlienHorde horde;
        private Bullets b;

	/* uncomment once you are ready for this part
	 *
   private AlienHorde horde;
	private Bullets shots;
	*/

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other instance variables
		//Ship, Alien
                ship = new Ship(300, 450);
                b = new Bullets();
                horde = new AlienHorde(8);
                for (int x = 8; x <  700; x += 100)
		{
                   for (int y = 22; y < 600 / 1.5; y += (600 / 1.5) / 4)
			{
				horde.add(new Alien(x + 20, y, 20, 20, 1));
			}
		}
		this.addKeyListener(this);
		new Thread(this).start();
                
		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
                
		if(keys[0] == true && ship.getX() > 0)
		{
			ship.move("LEFT");
		}
                if(keys[1] == true && ship.getX() < 750)
		{
			ship.move("RIGHT");
		}
                if(keys[2] == true && ship.getY() > 0)
		{
			ship.move("UP");
		}
                if(keys[3] == true && ship.getY() < 500)
		{
			ship.move("DOWN");
		}
                if (keys[4] == true){
                    b.add(new Ammo(ship.getX() + ship.getWidth()/2-2, ship.getY(), 5));
                    keys[4] = false;
                }
               b.moveEmAll();
               b.cleanEmUp();
     
		//add code to move Ship, Alien, etc.
               horde.moveEmAll();
               horde.removeDeadOnes(b.getList());
               horde.checkShipDeath(ship);
               if (horde.getSize() == 0){
                   System.out.println("You beat the aliens.");
			System.exit(0);
               }
		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship

                ship.draw(graphToBack);
                b.drawEmAll(graphToBack);
                horde.drawEmAll(graphToBack);
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

