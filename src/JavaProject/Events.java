/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;

/**
 *
 * @author line8847
 */
public class Events {
    private int date;
    private String description;
    
    public Events(int date, String description){
        this.date = date;
        this.description = description;
        
    }
    
    public int getDate(){
        return date;
    }
    
    public String getDes(){
        return description;
    }
    
    public String toString(){
        return date + " " + description;
    }
}
