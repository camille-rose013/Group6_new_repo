/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_app;

/**
 *
 * @author camil
 */
import java.util.Scanner;

public class LoginSystem {
    public String username;
    public String password;
    public boolean loggedIn;

    public LoginSystem(String username, String password) {
        this.username = username;
        this.password = password;
//        this.loggedIn = true;
    }

    public void start() {
        
        System.out.println("scanner is starting");
    
    }
        
    
    
//    public void login(String enteredUsername, String enteredPassword) {
//        if (enteredUsername.equals(username) && enteredPassword.equals(username)) {
//            System.out.println("Login successful!");
//        } else {
//            System.out.println("Incorrect username or password. Please try again.");
//        }
//    }

}