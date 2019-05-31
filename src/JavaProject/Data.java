/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;

import java.io.*;
import java.util.Scanner;
import java.io.File;


/**
 *
 * @author line8847
 */
public abstract class Data {
    public Data(){
        
    }
    public boolean findData(String fileName, String s) throws IOException{
        Scanner file = new Scanner(new File(fileName));
        while(file.hasNextLine()){
            String temp = file.nextLine();
            if (temp.equals(s)){
                return true;
            }
        }
        return false;
    }
    
    public void recordData(String fileName, String s) throws IOException{
        
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true)); 
        
        writer.write(s);
        writer.newLine();
        writer.close();
        
                
    }
    
}
