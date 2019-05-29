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
     
        Scanner file = new Scanner(new File("src/JavaProject/myTempFile.txt"));
        int size = file.nextInt();
        file.nextLine();
        
        EventsList e = new EventsList();
        
        for (int i = 0; i < size; i++){
          String temp = file.nextLine();
          int year = Integer.parseInt(temp.substring(0, temp.indexOf(" ")));
          int nextIndex = temp.indexOf(" ", temp.indexOf(" ")+1);
          int dateIndex = temp.indexOf(" ", nextIndex+1);  
          String month = temp.substring(temp.indexOf(" ")+1, nextIndex);
          int date = Integer.parseInt(temp.substring(nextIndex+1, dateIndex));
          String data = temp.substring(dateIndex+1);
          System.out.println(data);
          e.addEvent(new Events(year, month, date, data));
     
          
        }
        
        File tempFile = new File("src/JavaProject/myTempFile.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

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
        System.out.println("All upcoming events: ");
        writer.write(e.getList().size()+"\n");
        for (Events s: e.getList()){
            System.out.println(s.toString());
            writer.write(s.toString()+"\n");

        }
        writer.close();
        File f = new File("src/JavaProject/myTempFile.txt");
        boolean successful = tempFile.renameTo(f);
        
    }
    
}
