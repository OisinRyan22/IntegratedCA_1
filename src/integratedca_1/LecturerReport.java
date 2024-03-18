/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca_1;

/**
 *
 * @author ocean
 */
public class LecturerReport implements Report_Inter {
    private Database_Connection dbConnection;
    
    public LecturerReport(Database_Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public String generateReport() {
        return "Lecturer report data";
    }
}