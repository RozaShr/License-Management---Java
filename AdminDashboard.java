package LicenseManagement;

import java.util.Scanner;

public class AdminDashboard {
    private AdminClass admin;
    private ApprovalHandler approvalHandler;

    public AdminDashboard(AdminClass admin) {
        this.admin = admin;
        this.approvalHandler=new ApprovalHandler(admin);
    }

    public void showDashboard() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Admin Dashboard ===");
            System.out.println("1. View Applications");
            System.out.println("2. Approve Application");
            System.out.println("3. View Approved Applications");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    admin.showApplications();
                    break;
                case 2:
                    approvalHandler.processApplications(); // Let admin approve/reject applications
                    break;
                case 3:
                    admin.showApprovedApplications();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

