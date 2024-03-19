/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca_1;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ocean
 */
public class Office extends Users {
    private Database_Connection dbConnection;
    
   

    //Constructor 
    public Office(String username, String password, Database_Connection dbConnection) {
        super(username, password, "Office");    //Call the constructor of the superclass (USers) to initialize the username, password and role
        this.dbConnection = dbConnection;   //Initialize the database connection
    }
    //method to display options for generating reports
    @Override
    public void displayOptions(Scanner sc) {
        //Create instances of report classes
        CourseReport courseReport = new CourseReport(dbConnection);
        StudentReport studentReport = new StudentReport(dbConnection);
        LecturerReport lecturerReport = new LecturerReport(dbConnection);
        
        //display report options
        System.out.println("Choose a report you want to generate by entering a number corresponding to the report you want: ");
        System.out.println("1. Course Report");
        System.out.println("2. Student Report");
        System.out.println("3. Lecturer Report");
        
        int reportChoice = sc.nextInt();    //read users report choice
        sc.nextLine();
        
        String reportData = "";
        switch (reportChoice) {
            case 1:
                reportData = courseReport.generateReport(); //generate course report
                break;
            case 2:
                reportData = studentReport.generateReport();    //generate student report
                break;
            case 3:
                reportData = lecturerReport.generateReport();   //generate lecturer report
                break;
            default:
                System.out.println("Invalid Choice");
                return;
        }
        outputReport(reportData, sc);   //output the generated report
                
                
    }
    //Method to output the generated report
    private void outputReport(String reportData, Scanner sc) {
        //display options for choosing output format
        System.out.println("Choose an output format you want by entering the number corresponding to the file you want: ");
        System.out.println("1. Console");
        System.out.println("2. TXT file");
        System.out.println("3. CSV file");
        
        int formatChoice = sc.nextInt();    //read users format choice
        switch (formatChoice) { 
            case 1:
                System.out.println(reportData); //output to console
                break;
            case 2:
                writeToTxtFile(reportData, "report.txt");   //output to .txt file
                break;
            case 3:
                writeToCsvFile(reportData, "report.csv");   //output to .csv file
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    //method to write report to .txt file
    private void writeToTxtFile(String reportData, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(reportData);
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to TXT file: " + e.getMessage());
        }
    }
    //method to write report to .csv file
    private void writeToCsvFile(String reportData, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(reportData);
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
    
   
}
  

    

    
    