/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class Runner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Runner(String user)throws IOException
	{
		super("Events");
		setSize(WIDTH,HEIGHT);

		new eventsFrame(user).setVisible(true);



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
