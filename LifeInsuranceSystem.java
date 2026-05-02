package com.lims;

import java.util.*;

/**
 * Life Insurance Management System (LIMS)
 * Console-based Java application with MySQL backend via JDBC.
 *
 * Modules:
 *   1. Customer Management
 *   2. Policy Management
 *   3. Claims Processing
 *   4. Reporting
 *
 * To run:
 *   1. Set up MySQL DB using sql/schema.sql
 *   2. Update DB credentials in DatabaseConnection.java
 *   3. Compile and run: javac com/lims/*.java && java com.lims.LifeInsuranceSystem
 */
public class LifeInsuranceSystem {

    // In-memory lists (used in standalone mode without MySQL)
    static List<Customer> customers = new ArrayList<>();
    static List<Policy>   policies  = new ArrayList<>();
    static List<Claim>    claims    = new ArrayList<>();
    static Scanner        scanner   = new Scanner(System.in);
    static int            idCounter = 1;

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   Life Insurance Management System");
        System.out.println("==========================================");

        int choice;
        do {
            displayMenu();
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: addCustomer();    break;
                case 2: viewCustomers();  break;
                case 3: addPolicy();      break;
                case 4: viewPolicies();   break;
                case 5: fileClaim();      break;
                case 6: viewClaims();     break;
                case 7: generateReport(); break;
                case 8: System.out.println("Exiting LIMS. Goodbye!"); break;
                default: System.out.println("Invalid option. Try again.");
            }
        } while (choice != 8);

        scanner.close();
    }

    // ---- Menu ----
    private static void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Add Customer");
        System.out.println("2. View Customers");
        System.out.println("3. Add Policy");
        System.out.println("4. View Policies");
        System.out.println("5. File Claim");
        System.out.println("6. View Claims");
        System.out.println("7. Generate Report");
        System.out.println("8. Exit");
    }

    // ---- Customer Management ----
    private static void addCustomer() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        customers.add(new Customer(idCounter++, name, email, phone, address));
        System.out.println("Customer added successfully.");
    }

    private static void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        System.out.println("\n--- Customers ---");
        customers.forEach(System.out::println);
    }

    // ---- Policy Management ----
    private static void addPolicy() {
        System.out.print("Enter Customer ID: ");
        int custId = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter Policy Number: ");
        String policyNo = scanner.nextLine();
        System.out.print("Enter Policy Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter Premium Amount: ");
        double premium = scanner.nextDouble();
        System.out.print("Enter Coverage Amount: ");
        double coverage = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String start = scanner.nextLine();
        System.out.print("Enter End Date (YYYY-MM-DD): ");
        String end = scanner.nextLine();

        policies.add(new Policy(idCounter++, custId, policyNo, type, premium, coverage, start, end));
        System.out.println("Policy added successfully.");
    }

    private static void viewPolicies() {
        if (policies.isEmpty()) {
            System.out.println("No policies found.");
            return;
        }
        System.out.println("\n--- Policies ---");
        policies.forEach(System.out::println);
    }

    // ---- Claims Processing ----
    private static void fileClaim() {
        System.out.print("Enter Customer ID: ");
        int custId = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter Policy Number: ");
        String policyNo = scanner.nextLine();
        System.out.print("Enter Claim Amount: ");
        double amount = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Enter Claim Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        claims.add(new Claim(idCounter++, custId, policyNo, amount, date));
        System.out.println("Claim filed successfully. Status: PENDING");
    }

    private static void viewClaims() {
        if (claims.isEmpty()) {
            System.out.println("No claims found.");
            return;
        }
        System.out.println("\n--- Claims ---");
        claims.forEach(System.out::println);
    }

    // ---- Reporting ----
    private static void generateReport() {
        System.out.println("\n========== SYSTEM REPORT ==========");
        System.out.println("Total Customers : " + customers.size());
        System.out.println("Total Policies  : " + policies.size());
        System.out.println("Total Claims    : " + claims.size());

        double totalPremium = policies.stream().mapToDouble(Policy::getPremiumAmount).sum();
        double totalClaims  = claims.stream().mapToDouble(Claim::getClaimAmount).sum();
        long pendingClaims  = claims.stream().filter(c -> c.getStatus() == Claim.Status.PENDING).count();

        System.out.printf("Total Premium Collected : Rs. %.2f%n", totalPremium);
        System.out.printf("Total Claim Amount      : Rs. %.2f%n", totalClaims);
        System.out.println("Pending Claims          : " + pendingClaims);
        System.out.println("====================================");
    }
}
