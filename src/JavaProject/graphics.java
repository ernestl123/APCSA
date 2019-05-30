/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;
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
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.FlowLayout;
/**
 *
 * @author line8847
 */
public class graphics extends Canvas implements Runnable {
    private BufferedImage back;
    static JTextField textfield1, textfield2, textfield3;
    public graphics(){
        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
    }
    public void update(Graphics window) {
        
    }
    public void paint(Graphics window){
        JFrame f = new JFrame("Text Field Examples");

        f.pack();
        f.setVisible(true);
    }
    
    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
