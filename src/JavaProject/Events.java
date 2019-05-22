/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;
import java.time.LocalDate;
/**
 *
 * @author line8847
 */
public class Events {
    private LocalDate date;
    private String info;
    
    public Events(int year, int month, int day, String info){
        this.date = LocalDate.of(year, month, day);
        this.info = info;
        
    }
    
    public LocalDate getDate(){
        return date;
    }
    
    public String getInfo(){
        return info;
    }
    
    public String toString(){
        return date + " " + info;
    }
}
