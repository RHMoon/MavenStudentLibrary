package com.devland;

import java.util.Scanner;

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
                    break;
                case 2:
                    System.out.println("Option 2.");
                    break;
                case 3:
                    System.out.println("Option 3.");
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
