package com.devland;

import java.util.Scanner;

import com.devland.Student.StudentRepository;
import com.devland.Util.DatabaseConnector;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        Scanner scanner = new Scanner(System.in);
        
        
        // System.out.print(input);
        int input;
        DatabaseConnector connector = new DatabaseConnector();
        connector.connect();
        StudentRepository studentRepository = new StudentRepository(connector);
        do {
            System.out.println("-----------------------------------");
            System.out.println("Hello! Welcome to DevLand School.");
            System.out.println("MENU");
            System.out.println("1 - Get all students.");
            System.out.println("2 - Insert new student.");
            System.out.println("3 - Search student by ID.");
            System.out.println("4 - Exit.");
            System.out.println("-----------------------------------");
            System.out.print("Pick your option: ");

            input = scanner.nextInt();

            switch (input) {
                case 1:
                    System.out.println("Option 1.");
                    studentRepository.getAllStudent();
                    break;
                case 2:
                    System.out.println("Option 2.");
                    // System.out.print("Input first name, last name, age: ");
                    // String inputFirstName = scanner.nextLine();
                    // String inputLastName = scanner.nextLine();
                    System.out.print("Input the first name: ");
                    String inputFirstName = scanner.next();
                    System.out.print("Input the last name: ");
                    String inputLastName = scanner.next();
                    System.out.println();
                    System.out.print("Input the age: ");
                    int inputAge = scanner.nextInt();
                    studentRepository.addStudent(inputFirstName,inputLastName,inputAge);
                    break;
                case 3:
                    System.out.println("Option 3.");
                    System.out.print("Input the ID: ");
                    int inputID = scanner.nextInt();
                    studentRepository.getByID(inputID);
                    break;
                case 4:
                    System.out.println("Option 4.");
                    System.exit(0);
            
                default:
                    break;
            }
        } while (input!=4);

        scanner.close();
        
    }
}
