/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;
import Picture_Lab.FileChooser;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import javax.imageio.ImageIO;
import java.io.BufferedWriter;

/**
 *
 * @author line8847
 */
public class tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
     
        EventsList e = new EventsList();
        e.addEvent(new Events(2010, 3, 4, "info"));
        e.addEvent(new Events(2019, 8, 4, "info"));
        e.organize();
        System.out.println(e.getList());
        
    }
    
}
