/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca_1;

/**
 *
 * @author ocean
 */
public class Lecturer extends Users {
    public Lecturer(String username, String password) {
        super(username, password, "Lecturer");
    }

    @Override
    public void displayOptions() {
        System.out.println("Lecturer Options: Generate Reports");
    }
    
}

