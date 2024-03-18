/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca_1;

/**
 *
 * @author ocean
 */
public class StudentReport implements Report_Inter {
    private Database_Connection dbConnection;
    
    public StudentReport(Database_Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public String generateReport() {
        return "Student report data";
    }
}