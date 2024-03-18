/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package integratedca_1;

/**
 *
 * @author ocean
 */
public class IntegratedCA_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database_Connection dbConnection = new Database_Connection();
        
        CourseReport courseReport = new CourseReport(dbConnection);
        StudentReport studentReport = new StudentReport(dbConnection);
        LecturerReport lecturerReport = new LecturerReport(dbConnection);
        
        //Gathers and displays course report data
        String courseReportData = courseReport.generateReport();
        System.out.println("Course Report:\n" + courseReportData);
        
        //Gathers and displays student report data
        String studentReportData = studentReport.generateReport();
        System.out.println("\nStudent Report\n" + studentReportData);
        
        //Gathers and displays lecturers report data
        String lecturerReportData = lecturerReport.generateReport();
        System.out.println("\nLecturer Report\n" + lecturerReportData);
    }
    
}
