/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author line8847
 */
public class tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EventsList e = new EventsList();
        Scanner keyboard = new Scanner(System.in);
        e.addEvent(new Events(2019, 6, 23, "Stuff"));
        e.addEvent(new Events(2019, 5, 24, "sdf"));
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
