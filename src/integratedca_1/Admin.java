/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ocean
 */
public class Admin extends Users {
    
    //Database for storing user info
    private static final Map<String, Users> userDatabase = new HashMap<>();
    
    //static initializer to add the admin to the database
    static {
        userDatabase.put("admin", new Admin("admin", "java"));
    }
    //Admin constructor
    public Admin(String username, String password) {
        super(username, password, "Admin");
    }
    //Method to display the admins options 
    @Override
    public void displayOptions(Scanner sc) {
        System.out.println("Admin Options:");
        System.out.println("1. Add User");
        System.out.println("2. Modify User");
        System.out.println("3. Delete User");
        System.out.println("4. Change Password");
        System.out.print("Select an optioin: ");
        
        int choice = sc.nextInt();
        sc.nextLine();
        
        switch (choice) {
            case 1:
                addUser(sc);
                break;
            case 2:
                modifyUser(sc);
                break;
            case 3:
                deleteUser(sc);
                break;
            case 4:
                changePassword(sc);
                break;
            default:
                System.out.println("Invalid option selected.");
                break;
        }
    }
    //method to add new user
    private void addUser(Scanner sc) {
       System.out.println("Enter username:");
       String username = sc.nextLine();
       System.out.println("Enter password:");
       String password = sc.nextLine();
       System.out.println("Enter role:");
       String role = sc.nextLine();
       
       userDatabase.put(username, new Users(username, password, role) {
           @Override
           public void displayOptions(Scanner sc) {
               
           }
       });
       System.out.println("User added successfully");
           
    }
    //method to modify existing user
    private void modifyUser(Scanner sc) {
        System.out.println("Enter username you would like to modify");
        String username = sc.nextLine();
        
        if (!userDatabase.containsKey(username)) {
            System.out.println("User not found.");
            return;
    }
        System.out.println("Enter new password");
        String newPassword = sc.nextLine();
        
        Users user = userDatabase.get(username);
        user.setPassword(newPassword);
        
        System.out.println("Password updated succesfully.");
    }
    //Method to delete an existing user
    private void deleteUser(Scanner sc) {
        System.out.println("Enter username of the user you wish to delete:");
        String username = sc.nextLine();
        
        if (userDatabase.remove(username) !=null) {
            System.out.println("User deleted succesfully.");
        } else {
            System.out.println("User not found.");
        }
    }
    //method for changing admin password
    @Override
    public void changePassword(Scanner sc) {
        System.out.println("Enter new password: ");
        String newPassword = sc.nextLine();
        setPassword(newPassword);
        System.out.println("Password changed succesfully.");
    }
 }
    
    


