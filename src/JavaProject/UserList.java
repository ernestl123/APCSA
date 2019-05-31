/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;

import java.io.*;
import java.util.*;

/**
 *
 * @author ernes
 */
public class UserList extends Data{
    public ArrayList<User> users;
    private String filePath = "src/JavaProject/users.txt";
    
    public UserList() throws IOException{
        Scanner file = new Scanner(new File(filePath));
        users = new ArrayList<User>();
        
        while (file.hasNextLine()){
            String temp = file.nextLine();
            String username = temp.substring(0, temp.indexOf(" "));
            String pw = temp.substring(temp.indexOf(" "));
            users.add(new User(username, pw));
        }
        
    }
    public void addU(String username, String pw) throws IOException{
        System.out.println(username+ pw);
        User u = new User(username, pw);
        users.add(u);

        super.recordData(filePath, username+" "+pw);
    }
    
    @Override
    public boolean findData(String username, String pw) throws IOException{
        Scanner file = new Scanner(new File(filePath));
        while(file.hasNextLine()){
            String temp = file.nextLine();
            if (username.equals(temp.substring(0, temp.indexOf(" ")))){
                return true;
            }
        }
        return false;
    }
}
