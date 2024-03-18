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
    
    public Lecturer(String username, String password, Database_Connection dbConnection) {
        super(username, password, "Lecturer");
        this.dbConnection = dbConnection;
    }

    @Override
    public void displayOptions(Scanner sc) {
        LecturerReport lecturerReport = new LecturerReport(dbConnection);
        String reportData = lecturerReport.generateReport();
        outputReport(reportData, sc);
    }

    private void outputReport(String reportData, Scanner sc) {
        System.out.println("Choose an output format you want by entering the number corresponding to the file you want: ");
        System.out.println("1. Console");
        System.out.println("2. TXT file");
        System.out.println("3. CSV file");
        
        int formatChoice = sc.nextInt();
        sc.nextLine();
        switch (formatChoice) {
            case 1:
                System.out.println(reportData);
                break;
            case 2:
                writeToTxtFile(reportData, "lecturer_report.txt");
                break;
            case 3:
                writeToCsvFile(reportData, "lecturer_report.csv");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void writeToTxtFile(String reportData, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(reportData);
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to TXT file: " + e.getMessage());
        }
    }

    private void writeToCsvFile(String reportData, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(reportData);
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        } 
    }
}


