package LicenseManagement;

import java.util.ArrayList;
import java.util.HashMap;

public class AdminClass{
    private String name;
    private String email;
    private String password;
    private ArrayList<UserApplication> applications;
    private ArrayList<UserApplication> approvedApplications;
    private HashMap<String, String> applicationStatus; // Store application status

    public AdminClass(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.applications= new ArrayList<>();
        this.approvedApplications = new ArrayList<>();
        this.applicationStatus = new HashMap<>();
    }

    public boolean validateLogin(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
    public void addApplication(UserApplication application) {
        applications.add(application);
    }

    public void showApplications() {
        System.out.println("\n=== Pending Applications ===");
        if (applications.isEmpty()) {
            System.out.println("No pending applications.");
            return;
        }
        for (int i = 0; i < applications.size(); i++) {
            System.out.println((i + 1) + ". " + applications.get(i));  //Displays Name
        }
    }
    public void approveApplication(int index) {
        if (index >= 0 && index < applications.size()) {
            UserApplication application = applications.remove(index);
            approvedApplications.add(application);

            System.out.println("Application approved: " + application.getApplicantName() +
                    " - " + application.getLicenseType() +
                    " (Application ID: " + application.getApplicationID() + ")");
        } else {
            System.out.println("Invalid selection. Please try again.");
        }
    }

    public void showApprovedApplications() {
        System.out.println("\n=== Approved Applications ===");
        if (approvedApplications.isEmpty()) {
            System.out.println("No approved applications yet.");
            return;
        }
        for (UserApplication app : approvedApplications) {
            System.out.println(app);  //Displays Name
        }
    }
    public String getApplicationStatus(String name) {
        for (UserApplication app : approvedApplications) {
            if (app.getApplicantName().equalsIgnoreCase(name)) {
                return "Approved (License Expiry: "+app.getExpiryDate()+")";
            }
        }
        for (UserApplication app : applications) {
            if (app.getApplicantName().equalsIgnoreCase(name)) {
                return "Pending";
            }
        }
        return "Rejected or Not Found";
    }

    //Method to get pending applications for ApprovalHandler
    public ArrayList<UserApplication> getPendingApplications() {
        return applications;
    }
    public HashMap<String, String> getApplicationStatus(){
        return applicationStatus;
    }

}


