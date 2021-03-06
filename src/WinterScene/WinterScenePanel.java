package WinterScene;

// (c) A+ Computer Science
// www.apluscompsci.com
// Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;
import static java.lang.Character.*;

public class WinterScenePanel extends JPanel implements Runnable, KeyListener {

    private List<AbstractShape> shapes;
    private AbstractShape sMan;
    private StormySnowFlakes storm;
    private boolean keyW;
    public WinterScenePanel() {
        setVisible(true);
        shapes = new ArrayList<AbstractShape>();
        for (int i = 0; i < 50; i++) {
            int y = (int) (Math.random() * 600);
            int s = (int) (Math.random() * 30) + 20;
            shapes.add(new SimpleSnowFlake(i * 14, y, s, s));
            shapes.add(new FancySnowFlake(i * 14, y, s, s));
        }
        sMan = new SnowMan(500, 350, 200, 150);
        keyW = false;
        storm = new StormySnowFlakes();
        addKeyListener(this);
        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        window.setColor(Color.BLUE);
        window.fillRect(0, 0, getWidth(), getHeight());
        window.setColor(Color.WHITE);
        window.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
        window.setFont(new Font("TAHOMA", Font.BOLD, 18));
        window.drawString("MAKE A WINTER SCENE!", 40, 40);
        
        sMan.draw(window);
        if (keyW == true){
                storm.startStorm(shapes, window);
                System.out.println("Starting storm");
            }
        else{
            for (AbstractShape sh : shapes) {
            
            sh.moveAndDraw(window);
            if (sh.getYPos() >= getHeight()) {
                sh.setYPos(0);
            }
        }
        
        }
    }

public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_W){
                    keyW = true;
                }
        }

public void keyReleased(KeyEvent e)
{
    if (e.getKeyCode() == KeyEvent.VK_W){
        keyW = false;
    }
}
public void keyTyped(KeyEvent e)
	{
	}
    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(35);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
