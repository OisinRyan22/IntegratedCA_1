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
public class LecturerReport implements Report_Inter {
    private Database_Connection dbConnection;
    
    public LecturerReport(Database_Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public String generateReport() {
    StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Lecturer Report:\n");
        
        String query = "SELECT name, role, classes_taught, students_count FROM lecturers";
        
         try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             
             while (rs.next()) {
                 String name = rs.getString("name");
                 String role = rs.getString("role");
                 String classesTaught = rs.getString("classes_taught");
                 int studentsCount = rs.getInt("students_count");
                 
                 
                 reportBuilder.append("Name: ").append(name)
                         .append("\nRole: ").append(role)
                         .append("\nClasses Taught: ").append(classesTaught)
                         .append("\nStudents Count: ").append(studentsCount)
                         .append("\n\n");
                         
              }
         } catch (SQLException e) {
             e.printStackTrace();
         }
        return reportBuilder.toString();
    }
}   
    