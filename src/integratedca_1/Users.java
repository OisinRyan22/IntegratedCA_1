/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca_1;

import java.util.Scanner;

/**
 *
 * @author ocean
 */
public abstract class Users {
    //Fields to store username, password and role
    protected String username;
    protected String password;
    protected String role;
    
    //constructor to initialize username, password and role
    public Users(String username, String password, String role) {
    this.username = username;
    this.password = password;
    this.role = role;
}
    //Abstract method to display options for the user
    public abstract void displayOptions(Scanner sc);
    
    //method to change the users password
    public void changePassword(Scanner sc) {
        System.out.println("Enter new password: ");
        String newPassword = sc.nextLine();
        setPassword(newPassword);
        System.out.println("Password changed succesfully.");
        
}
    //setter method for password
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
