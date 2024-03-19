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
public class Lecturer extends Users {
    private Database_Connection dbConnection;
    
    //Constructor
    public Lecturer(String username, String password, Database_Connection dbConnection) {
        super(username, password, "Lecturer");  //Call superclass constructor
        this.dbConnection = dbConnection;   //Initialize database connection
    }
    //Override displayOptions method
    @Override 
    public void displayOptions(Scanner sc) {
        LecturerReport lecturerReport = new LecturerReport(dbConnection);   //Create a new LecturerReport instance with database connection
        String reportData = lecturerReport.generateReport();    //generate report data
        outputReport(reportData, sc);   //output report based on user choice
    }
    //Method to output report based on user choice
    private void outputReport(String reportData, Scanner sc) {
        //display options for output format
        System.out.println("Choose an output format you want by entering the number corresponding to the file you want: ");
        System.out.println("1. Console");
        System.out.println("2. TXT file");
        System.out.println("3. CSV file");
        
        //Read user choice
        int formatChoice = sc.nextInt();
        sc.nextLine();
        //Perform actions based on user choice
        switch (formatChoice) {
            case 1:
                System.out.println(reportData); //Output report to console
                break;
            case 2:
                writeToTxtFile(reportData, "lecturer_report.txt");  //output report to .txt file
                break;
            case 3:
                writeToCsvFile(reportData, "lecturer_report.csv");  //output report to .csv file
                break;
            default:
                System.out.println("Invalid choice");   //error message
        }
    }
    //method to write report to .txt file
    private void writeToTxtFile(String reportData, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(reportData);    //write report to.txt file
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to TXT file: " + e.getMessage());
        }
    }
    //method to write report to .csv file
    private void writeToCsvFile(String reportData, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(reportData);    //write report to .csv file
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        } 
    }
}


