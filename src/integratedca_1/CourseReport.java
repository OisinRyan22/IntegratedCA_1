/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca_1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ocean
 */
public class CourseReport implements Report_Inter {
    private Database_Connection dbConnection;
    
    //Constructor to initialize CourseReport with a database connection
    public CourseReport(Database_Connection dbConnection) {
        this.dbConnection = dbConnection;
    }
    //Method to generate course report
    @Override
    public String generateReport() {
        //StringBuilder to construct the report
        StringBuilder reportBuilder = new StringBuilder();  
        reportBuilder.append("Course Report:\n");
        
        //SQL query to retrieve course information 
        String query = "SELECT c.title, c.description, COUNT(e.student_id) AS student_count, " +
                       "l.name AS lecturer, c.room_assignment " +
                       "FROM courses c " +
                       "LEFT JOIN enrollments e ON c.course_id = e.course_id " +
                       "LEFT JOIN lecturers l ON c.lecturer_id = l.lecturer_id " +
                       "GROUP BY c.course_id, c.title, c.description, l.name, c.room_assignment, c.is_online";
        
        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            //iterate through the result set and append course details to the report
            while (rs.next()) {
                String title = rs.getString("title");
                String program = rs.getString("description");
                int studentCount = rs.getInt("student_count");
                String lecturer = rs.getString("lecturer");
                //If room assignment is empty, set it to "Online"
                String roomAssignment = rs.getString("room_assignment"). isEmpty() ? "Online" : rs.getString("room_assignment");
                
                //Append course details to the report
                reportBuilder.append(String.format("Title: %s%nProgram: %s%nStudents Enrolled: %d%nLecturer: %s%n Room: %s%n%n",
                        title, program, studentCount, lecturer, roomAssignment));
            }
                
            } catch (SQLException ex) {
            Logger.getLogger(CourseReport.class.getName()).log(Level.SEVERE, null, ex); //Handle SQL exception
        }
        return reportBuilder.toString();    //Return the generated report as a string
    }
}    
