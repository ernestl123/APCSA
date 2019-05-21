/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
/**
 *
 * @author line8847
 */
public class EventsList {
    private List<Events> eventList;
    
    public EventsList(){
        eventList = new ArrayList<Events>();
    }
    
    public void addEvent(Events e){
        eventList.add(e);
    }
    
    public void organize(){
        LocalDate myObj = LocalDate.now();
        for (Events e: eventList){
            if 
        }
    }
}
