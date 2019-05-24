/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
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
    
    public List<Events> getList(){
        return eventList;
    }
    
    public void organize(){
        //Removes all expired events
        LocalDate current = LocalDate.now();
        ArrayList<Events> temp = new ArrayList<Events>();
        for (Events e: eventList){
            LocalDate d = e.getDate();
            if (!(d.compareTo(current) < 0)){
                temp.add(e);
            }
        }
        //Sorts all event objects by date
        Collections.sort(temp, new Comparator<Events>(){
             public int compare(Events e1, Events e2) {
               return e1.getDate().compareTo(e2.getDate());
            }
        });
        //Make new organized list
        eventList = new ArrayList<Events>();
        for (Events e: temp){
            eventList.add(e);
        }
        
    }
}
