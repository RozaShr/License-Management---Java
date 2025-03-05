package LicenseManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<UserClass> users = new ArrayList<>();
    private static AdminClass admin = new AdminClass("Admin", "admin@system.com", "admin@123");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== License Management System ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                register(sc);
            } else if (choice == 2) {
                login(sc);
            } else {
                break;
            }
        }
    }

    private static void register(Scanner sc) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        if (!UserClass.isValidEmail(email)) {
            System.out.println("Invalid email address. Please use a gmail.com email address.");
            return;
        }
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Enter Citizenship Number: ");
        int citizenship = sc.nextInt();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        System.out.print("Register as (Admin/User): ");
        String role = sc.nextLine();

        if (role.equalsIgnoreCase("Admin")) {
            System.out.println("Admin registration is not allowed here.");
        } else {
            users.add(new UserClass(name, address, email, phone, citizenship, age, password, "User"));
            System.out.println("Registration successful!");
        }
    }

    private static void login(Scanner sc) {
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (admin.validateLogin(email, password)) {
            System.out.println("Login successful! Welcome Admin.");
            new AdminDashboard(admin).showDashboard();
            return;
        }

        for (UserClass user : users) {
            if (user.validateLogin(email, password)) {
                System.out.println("Login successful!");
                new UserDashboard(user, admin).showDashboard();
                return;
            }
        }
        System.out.println("Invalid email or password.");
    }
}
