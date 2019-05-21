/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author line8847
 */
public class User {
    private String username;
    private String password;
    private List<Events> eventList;
    public User(String username, String password){
        this.username = username;
        this.password = password;
        eventList = new ArrayList<Events>();
    }
    
    public String getUsername(){
        return username;
    }
    public boolean checkPassword(String password){
        return this.password.equals(password);
    }
    
    public void addEvent(Events e){
        eventList.add(e);
    }
    
    public List<Events> getEvents(){
        
        return eventList;
    }
}
