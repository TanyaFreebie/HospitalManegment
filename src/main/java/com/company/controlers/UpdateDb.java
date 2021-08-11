package com.company.controlers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateDb {

    private static final Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("MAIN MENU");
        System.out.println("1. Patients");
        System.out.println("2. Doctors");


        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                patientMenu();
                break;
            case 2:
                doctorsMenu();
                break;

            default:
                System.out.println("Invalid option");
        }

        System.out.println("Do you wish to proceed Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {
            System.out.println("redirecting to main menu");
            mainMenu();
        }

        else{


            System.out.println("End of session. User logout");//log out user
        }
    }

    public static void patientMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("PATIENTS MENU");
        System.out.println("1. Add new patient");
        System.out.println("2. Edit name");
        System.out.println("3. Edit surname");
        System.out.println("4. Assign new doctor");
        System.out.println("5. Add patients diagnosis");
        System.out.println("6. Observe admissions");
        System.out.println("7. Add sign out date");
        System.out.println("8. Delete patient from database");

        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                PatientController.addNewPatient();
                break;
            case 2:
                PatientController.editPatientName();
                break;
            case 3:
                PatientController.editPatientSurname();
                break;
            case 4:
                PatientController.assignSpecialist();
                break;
            case 5:
                PatientController.assignDiagnosis();
                break;
            case 6:
                AdmissionsController.reviewAdmissionsByPatient();
                break;
            case 7:
                PatientController.dischargeFromHospital();
                break;
            case 8:
                PatientController.deletePatient();
                break;
            default:
                System.out.println("Invalid option");


        }
        System.out.println("Do you wish to proceed Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {
            System.out.println("redirecting to main menu");
            mainMenu();
        }

        else{


            System.out.println("End of session. User logout");//log out user
        }
    }

    public static void doctorsMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("DOCTORS MENU");
        System.out.println("1. Add new doctor");
        System.out.println("2. Edit name");
        System.out.println("3. Edit surname");
        System.out.println("4. Edit speciality");
        System.out.println("5. Assign new patient");
        System.out.println("6. Add new diagnosis to database");
        System.out.println("7. Edit diagnosis label");
        System.out.println("8. Edit diagnosis description");
        System.out.println("9. Remove diagnosis from database");
        System.out.println("10. Add drugs");
        System.out.println("11. Edit drugs name");
        System.out.println("12. Edit storage remains");
        System.out.println("13. Delete drug");
        System.out.println("14. Add admission to the patient");
        System.out.println("15. Cancel admission");
        System.out.println("16. Delete doctor from database");


        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                DoctorController.addNewDoctor();
                break;
            case 2:
                DoctorController.editDoctorsName();
                break;
            case 3:
                DoctorController.editDoctorsSurname();
                break;
            case 4:
                DoctorController.editDoctorsSpeciality();
                break;
            case 5:
                PatientController.assignSpecialist();
                break;
            case 6:
                DiagnosisController.addNewDiagnosis();
                break;
            case 7:
                DiagnosisController.editDiagnosisName();
                break;
            case 8:
                DiagnosisController.editDescription();
                break;
            case 9:
                DiagnosisController.deleteDiagnosis();
                break;
            case 10:
                DrugController.addNewDrug();
                break;
            case 11:
                DrugController.editDrugsName();
                break;
            case 12:
                DrugController.editDrugsStorage();
                break;
            case 13:
                DrugController.deleteDrug();
                break;
            case 14:
                AdmissionsController.newAdmission();
                break;
            case 15:
                AdmissionsController.cancelAdmission();
                break;
            case 16:
                DoctorController.deleteDoctor();
                break;

            default:
                System.out.println("Invalid option");
        }

        System.out.println("Do you wish to proceed Y/N");
        String endSession = scanner.next().trim();
        if (endSession.equals("Y")) {
            System.out.println("redirecting to main menu");
            mainMenu();
        }

     else{


        System.out.println("End of session. User logout");//log out user
    }
}
}
