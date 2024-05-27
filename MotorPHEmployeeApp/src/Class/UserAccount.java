/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.io.*;
import java.util.*;

/**
 *
 * @author 63909
 */
public class UserAccount {    
    private String userID;
    private String username;
    private String password;
    private ArrayList<String> userData;
    private boolean authenticationResult;
    //private UserRole role;
    private HashMap<String,String[]> userMap;
    private String[] userInfo;
    
    
    // getters and setters
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }        

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }      

    // getters and setters   
    public void setUserMap(ArrayList<String> dataFile) {
        this.userData = dataFile;
        this.userMap = new HashMap<String, String[]>();
        
        for (String i : this.userData){
            String[] row = i.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            this.userMap.put(row[2],row);
        }                    
    }        
    public HashMap<String, String[]> getUserMap() {
        return userMap;
    }

    public String[] getUserInfo() {
        return userInfo;
    }
    public void setUserInfo(String[] userInfo) {
        this.userInfo = userInfo;
    }

    public boolean loggingIn(String username, String password) {
        this.username = username;
        this.password = password;        

        if(this.userMap.containsKey(this.username)){
            if(this.userMap.get(this.username)[3].equals(this.password)){
                authenticationResult = true;
            } else {
                authenticationResult = false;
            }
        } else {
            authenticationResult = false;
        }

        return authenticationResult;
    }        
        
}
