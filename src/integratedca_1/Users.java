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
    protected String username;
    protected String password;
    protected String role;
    
    public Users(String username, String password, String role) {
    this.username = username;
    this.password = password;
    this.role = role;
}
    public abstract void displayOptions(Scanner sc);
    
    public void changePassword(Scanner sc) {
        System.out.println("Enter new password: ");
        String newPassword = sc.nextLine();
        setPassword(newPassword);
        System.out.println("Password changed succesfully.");
        
}
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
