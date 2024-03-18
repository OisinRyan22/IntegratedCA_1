/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca_1;

/**
 *
 * @author ocean
 */
public class Office extends Users {
    public Office(String username, String password) {
        super(username, password, "Office");
    }

    @Override
    public void displayOptions() {
        System.out.println("Office Options: Generate Reports");
    }
    
}
