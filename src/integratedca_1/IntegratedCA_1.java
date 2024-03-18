/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package integratedca_1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author ocean
 */
public class IntegratedCA_1 {

    /**
     * @param args the command line arguments
     */
    private static void writeToTxtFile(String report, String filename) {
        try ( PrintWriter out = new PrintWriter(filename)) {
            out.println(report);
        } catch (FileNotFoundException e) {
            System.err.println("error writing to TXT file: " + e.getMessage());
        }
    }

    private static void writeToCsvFile(String report, String filename) {
        try ( PrintWriter out = new PrintWriter(filename)) {
            out.println(report);
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to CSV file" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Database_Connection dbConnection = new Database_Connection();

        CourseReport courseReport = new CourseReport(dbConnection);
        StudentReport studentReport = new StudentReport(dbConnection);
        LecturerReport lecturerReport = new LecturerReport(dbConnection);

//        //Gathers and displays course report data
//        String courseReportData = courseReport.generateReport();
//        System.out.println("Course Report:\n" + courseReportData);
//        
//        //Gathers and displays student report data
//        String studentReportData = studentReport.generateReport();
//        System.out.println("\nStudent Report\n" + studentReportData);
//        
//        //Gathers and displays lecturers report data
//        String lecturerReportData = lecturerReport.generateReport();
//        System.out.println("\nLecturer Report\n" + lecturerReportData);
        System.out.println("Choose a report you want to generate by entering a number corresponding to the report you want: ");
        System.out.println("1. Course Report");
        System.out.println("2. Student Report");
        System.out.println("3. Lecturer Report");
        Scanner sc = new Scanner(System.in);
        int reportChoice = sc.nextInt();

        String reportData = "";
        String reportType = "";

        switch (reportChoice) { 
            case 1:
                reportData = courseReport.generateReport();
                reportType = "CourseReport";
                break;

            case 2: 
                reportData = studentReport.generateReport();
                reportType = "StudentReport";
                break;
                
            case 3: 
                reportData = lecturerReport.generateReport();
                reportType = "LecturerReport";
                break;
            default:
                System.out.println("Invalid report choice.");
                return;
        }
        
        System.out.println("Choose the output format by entering a number that corresponds with the file output : \n1. Console\n2. TXT File\n3. CSV File");
        int formatChoice = sc.nextInt();
        
        switch (formatChoice) {
            case 1:     //outputs to console
                System.out.println(reportData);
                break;
                
            case 2:     //Outputs to .txt file
                writeToTxtFile(reportData, reportType + ".txt");
                System.out.println("Report written to " + reportType + ".txt");
                break;
                
             case 3:        //Outputs to .csv file
                writeToCsvFile(reportData, reportType + ".csv");
                System.out.println("Report written to " + reportType + ".csv");
                break;    
             default:
                 System.out.println("Invalid format choice");
        }
    }

}
