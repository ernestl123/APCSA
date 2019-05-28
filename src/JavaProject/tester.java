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

/**
 *
 * @author line8847
 */
public class tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        // TODO code application logic here
        
        Scanner file = new Scanner(new File("src/JavaProject/text.dat"));
        int size = file.nextInt();
        file.nextLine();
        
        EventsList e = new EventsList();
        
        for (int i = 0; i < size; i++){
          String temp = file.nextLine();
          int year = Integer.parseInt(temp.substring(0, temp.indexOf(" ")));
          int nextIndex = temp.indexOf(" ", temp.indexOf(" "));
          int dateIndex = temp.indexOf(" ", nextIndex);  
          int dataIndex = temp.indexOf(" ", dateIndex);
          int month = Integer.parseInt(temp.substring(nextIndex, dateIndex));
          int date = Integer.parseInt(temp.substring(dateIndex, dataIndex));
          String data = temp.substring(dataIndex);
          e.addEvent(new Events(year, month, date, data));
          
        }
        

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter year: ");
        int year = keyboard.nextInt();
        System.out.println("enter month:");
        int month = keyboard.nextInt();
        System.out.println("Enter day");
        int day = keyboard.nextInt();
        System.out.println("Enter info");
        String info = keyboard.next();
        e.addEvent(new Events(year, month, day, info));
        e.organize();
        
        for (Events s: e.getList()){
            System.out.println(s.getDate());
            System.out.println(s.getInfo());
        }
        
    }
    
}
