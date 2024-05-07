/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_app;

import java.util.Scanner;

/**
 *
 * @author camil
 */
public class login {
    private String username;
    private String password;
 
    public login (String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public void logingIn() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();
        
         if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
            System.out.println("Login successful!");
            System.out.println("welcome" + " " + username );
        } else {
            System.out.println("Incorrect username or password. Please try again.");
        }
        
         
        
         
        scanner.close(); // Close the scanner
    }
    
    
    
    
}
