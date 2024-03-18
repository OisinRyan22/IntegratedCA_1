/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca_1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Student Report:\n");
        
        String query = "SELECT name, student_number, programme, modules_enrolled, modules_completed, modules_to_repeat FROM students";
        
         try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             
             while (rs.next()) {
                 String name = rs.getString("name");
                 String studentNumber = rs.getString("student_number");
                 String programme = rs.getString("programme");
                 String modulesEnrolled = rs.getString("modules_enrolled");
                 String modulesCompleted = rs.getString("modules_completed");
                 String modulesToRepeat = rs.getString("modules_to_repeat");
                 
                 reportBuilder.append("Name: ").append(name)
                         .append("\nStudent Number: ").append(studentNumber)
                         .append("\nProgramme: ").append(programme)
                         .append("\nModules Enrolled: ").append(modulesEnrolled)
                         .append("\nModules Completed: ").append(modulesCompleted)
                         .append("\nModules To Repeat: ").append(modulesToRepeat)
                         .append("\n\n");
                         
              }
         } catch (SQLException e) {
             e.printStackTrace();
         }
        return reportBuilder.toString();
    }
}
   