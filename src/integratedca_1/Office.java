/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca_1;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 *
 * @author ocean
 */
public class Office extends Users {
    private Database_Connection dbConnection;
    
    public Office(String username, String password, Database_Connection dbConnection) {
        super(username, password, "Office");
        this.dbConnection = dbConnection;
    }

    @Override
    public void displayOptions(Scanner sc) {
        CourseReport courseReport = new CourseReport(dbConnection);
        StudentReport studentReport = new StudentReport(dbConnection);
        LecturerReport lecturerReport = new LecturerReport(dbConnection);
        
        System.out.println("Choose a report you want to generate by entering a number corresponding to the report you want: ");
        System.out.println("1. Course Report");
        System.out.println("2. Student Report");
        System.out.println("3. Lecturer Report");
        
        int reportChoice = sc.nextInt();
        sc.nextLine();
        
        String reportData = "";
        switch (reportChoice) {
            case 1:
                reportData = courseReport.generateReport();
                break;
            case 2:
                reportData = studentReport.generateReport();
                break;
            case 3:
                reportData = lecturerReport.generateReport();
                break;
            default:
                System.out.println("Invalid Choice");
                return;
        }
        outputReport(reportData, sc);
                
                
    }

    private void outputReport(String reportData, Scanner sc) {
        System.out.println("Choose an output format you want by entering the number corresponding to the file you want: ");
        System.out.println("1. Console");
        System.out.println("2. TXT file");
        System.out.println("3. CSV file");
        
        int formatChoice = sc.nextInt();
        switch (formatChoice) {
            case 1:
                System.out.println(reportData);
                break;
            case 2:
                writeToTxtFile(reportData, "report.txt");
                break;
            case 3:
                writeToCsvFile(reportData, "report.csv");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void writeToTxtFile(String reportData, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(reportData);
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to TXT file: " + e.getMessage());
        }
    }

    private void writeToCsvFile(String reportData, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(reportData);
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
    
   
}
  

    

    
    