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
    private String[] stuff = {"", "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
    
    public Events(int year, String month, int day, String info){
        int monthValue =1;
        for (int i = 0; i < stuff.length; i++){
            if (stuff[i].equals(month)){
                monthValue = i;
                break;
            }
        }
        this.date = LocalDate.of(year, monthValue, day);
        this.info = info;
        
    }
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
        return date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth() + " " + info;
    }
}
