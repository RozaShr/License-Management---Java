package LicenseManagement;

import java.time.LocalDate;
import java.util.UUID;

public class UserApplication {
    private String applicantName;
    private String licenseType;
    private LocalDate applicationDate;
    private LocalDate expiryDate;
    private String applicationID;

    public UserApplication(String applicantName, String licenseType) {
        this.applicantName = applicantName;
        this.licenseType = licenseType;
        this.applicationID = UUID.randomUUID().toString().substring(0,8);
        this. applicationDate = LocalDate.now();
        this.expiryDate = applicationDate.plusYears(5);
    }
    public String getApplicationID(){
        return applicationID;
    }
    public String getApplicantName() {
        return applicantName;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public LocalDate getExpiryDate(){
        return expiryDate;
    }

//    @Override
//    public String toString() {
//        return "Applicant: " + applicantName + ", License Type: " + licenseType;
//    }

    @Override
    public String toString() {
        return "Application ID: " + applicationID+ " | Applicant: " + applicantName + " | License Type: " + licenseType;
    }
}

