package me.vasujain;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/customers.json";
        String outputFilePath = "src/main/resources/sorted_customers.json";

        try (Scanner scanner = new Scanner(System.in)) {
            // Menu
            System.out.println("Customer Data Sorting Application");
            System.out.println("=================================");
            System.out.println("Choose a sorting algorithm:");
            System.out.println("1. Quick Sort");
            System.out.println("2. Merge Sort");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            // Load customer data
            List<Customer> customers = FileHandler.readCustomersFromFile(inputFilePath);

            switch (choice) {
                case 1:
                    System.out.println("Sorting using Quick Sort...");
                    CustomerDataSorter.quickSort(customers, 0, customers.size() - 1);
                    break;

                case 2:
                    System.out.println("Sorting using Merge Sort...");
                    CustomerDataSorter.mergeSort(customers, 0, customers.size() - 1);
                    break;

                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Exiting.");
                    return;
            }

            // Save sorted data
            FileHandler.writeCustomersToFile(outputFilePath, customers);

            System.out.println("Customer data sorted successfully and saved to: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
