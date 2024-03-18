/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca_1;

/**
 *
 * @author ocean
 */
public class Admin extends Users {
    public Admin(String username, String password) {
        super(username, password, "Admin");
    }

    @Override
    public void displayOptions() {
        System.out.println("Admin Options:");
    }
    
    public void addUser() {
        System.out.println("Adding a user (NOT FULLY IMPLEMENTED).");
    }
    
    public void modifyUser() {
        System.out.println("Modifying a user (NOT FULLY IMPLEMENTED).");
    }
    
    public void deleteUser() {
        System.out.println("Deleting a user (NOT FULLY IMPLEMENTED).");
    }
}

