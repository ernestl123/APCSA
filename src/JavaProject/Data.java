/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author line8847
 */
public class Data {
    public boolean findData(String s1, String s2, String fileName) throws IOException{
       Scanner file = new Scanner(new File(fileName));
       boolean found = false;
        int size = file.nextInt();
        file.nextLine();

        for (int i = 0; i < size; i++){
            String temp = file.nextLine();
            if (temp.substring(0, temp.indexOf((" "))).equals(s1) && temp.substring(temp.indexOf(" ")+1).equals(s2)){
                found = true;
            }
            file.nextLine();
        }
        return found;
    }
}
