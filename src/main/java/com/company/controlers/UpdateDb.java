package com.company.controlers;

import jdk.nashorn.internal.ir.Assignment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.Scanner;

public class UpdateDb {

    private static final Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("MAIN MENU");
        System.out.println("");
        System.out.println("1. Administration");
        System.out.println("2. Doctors ");
        System.out.println("3. Patients update");

        System.out.println("");

        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                administrationMenu();
                break;
            case 2:
                doctorsMenu();
                break;
            case 3:
                patientMenu();
                break;

            default:
                System.out.println("");
                System.out.println("Invalid option");
                System.out.println("");
                System.out.println("Do you wish to proceed Y/N");
                String endSession = scanner.next().trim();
                System.out.println("");
                if (endSession.equals("Y")) {

                    System.out.println("redirecting to start");
                    mainMenu();
                }

                else{


                    System.out.println("End of session. User logout");//log out user
                }

        }

    }

    public static void patientMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("PATIENTS MENU");
        System.out.println("");


        System.out.println("1. Assign new doctor");
        System.out.println("2. Add patients diagnosis");
        System.out.println("3. Observe admissions");
        System.out.println("4. Cancel admission");
        System.out.println("5. Add sign out date");
        System.out.println("");
        System.out.println("Select an option");
        int option = scanner.nextInt();
        System.out.println("");
        switch (option) {
            case 1:
                PatientController.assignSpecialist();
                break;
            case 2:
                PatientController.assignDiagnosis();
                break;
            case 3:
                AdmissionsController.newAdmission();
                break;
            case 4:
                AdmissionsController.cancelAdmission();
                break;
            case 5:
             PatientController.dischargeFromHospital();
                break;

            default:
                System.out.println("");
                System.out.println("Invalid option");
                System.out.println("");
        }

        System.out.println("Do you wish to proceed Y/N");
        String endSession = scanner.next().trim();
        System.out.println("");
        if (endSession.equals("Y")) {
            System.out.println("redirecting to main menu");
            System.out.println("");
            mainMenu();

        }

        else{


            System.out.println("End of session. User logout");//log out user
        }
    }

    public static void doctorsMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("DOCTORS MENU");
        System.out.println("");
        System.out.println("1. Assign new patient");
        System.out.println("2. Update  patients diagnosis");
        System.out.println("3. Add admission to the patient");
        System.out.println("4. Cancel admission");
        System.out.println("");

        System.out.println("Select an option");
        int option = scanner.nextInt();
        System.out.println("");
        switch (option) {
            case 1:
                PatientController.assignSpecialist();
                break;
            case 2:
                PatientController.assignDiagnosis();
                break;
            case 3:
               AdmissionsController.newAdmission();
                break;
            case 4:
                AdmissionsController.cancelAdmission();
                break;

            default:
                System.out.println("");
                System.out.println("Invalid option");
                System.out.println("");
        }

        System.out.println("Do you wish to proceed Y/N");
        String endSession = scanner.next().trim();
        System.out.println("");
        if (endSession.equals("Y")) {
            System.out.println("redirecting to main menu");
            System.out.println("");
            mainMenu();

        }

     else{


        System.out.println("End of session. User logout");//log out user
    }
}

    public static void administrationMenu(){
    System.out.println("ADMINISTRATION");
    System.out.println("");
    System.out.println("1. Doctor admin menu");
    System.out.println("2. Patient admin menu");
    System.out.println("3. Diagnosis admin menu");
    System.out.println("4. Drug admin menu");
    System.out.println("");
    System.out.println("Select an option");
    int option = scanner.nextInt();
    System.out.println("");
    switch (option) {
        case 1:
            adminDoctor();
            break;
        case 2:
            adminPatient();
            break;
        case 3:
            adminDiagnosis();
            break;
        case 4:
            adminDrugs();
            break;

        default:
            System.out.println("");
            System.out.println("Invalid option");
            System.out.println("");
    }

    System.out.println("Do you wish to proceed Y/N");
    String endSession = scanner.next().trim();
    System.out.println("");
    if (endSession.equals("Y")) {
        System.out.println("redirecting to main menu");
        System.out.println("");
        mainMenu();

    }

    else{


        System.out.println("End of session. User logout");//log out user
    }







    }

    public static void adminPatient(){
        System.out.println("Patient ADMIN menu");
        System.out.println("");
        System.out.println("1. Add new patient");
        System.out.println("2. Delete patient from database");
        System.out.println("3. Edit name");
        System.out.println("4. Edit surname");
        System.out.println("");

        System.out.println("Select an option");
        int option = scanner.nextInt();
        System.out.println("");
        switch (option) {
            case 1:
                PatientController.addNewPatient();
                break;
            case 2:
                PatientController.deletePatient();
                break;
            case 3:
                PatientController.editPatientName();
                break;
            case 4:
                PatientController.editPatientSurname();
                break;

            default:
                System.out.println("");
                System.out.println("Invalid option");
                System.out.println("");
        }

        System.out.println("Do you wish to proceed Y/N");
        String endSession = scanner.next().trim();
        System.out.println("");
        if (endSession.equals("Y")) {
            System.out.println("redirecting to main menu");
            System.out.println("");
            mainMenu();

        }

        else{


            System.out.println("End of session. User logout");//log out user
        }

    }

    public static void adminDoctor(){
        System.out.println("Doctors ADMIN menu");
        System.out.println("");
        System.out.println("1. Add new doctor");
        System.out.println("2. Edit name");
        System.out.println("3. Edit surname");
        System.out.println("4. Edit speciality");
        System.out.println("5. Delete doctor from database");
        System.out.println("");
        System.out.println("Select an option");
        int option = scanner.nextInt();
        System.out.println("");
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
                DoctorController.deleteDoctor();
                break;

            default:
                System.out.println("");
                System.out.println("Invalid option");
                System.out.println("");
        }

        System.out.println("Do you wish to proceed Y/N");
        String endSession = scanner.next().trim();
        System.out.println("");
        if (endSession.equals("Y")) {
            System.out.println("redirecting to main menu");
            System.out.println("");
            mainMenu();

        }

        else{


            System.out.println("End of session. User logout");//log out user
        }


    }

    public static void adminDiagnosis(){
        System.out.println("Diagnosis ADMIN menu");
        System.out.println("");
        System.out.println("1. Add new diagnosis to database");
        System.out.println("2. Edit diagnosis label");
        System.out.println("3. Edit diagnosis description");
        System.out.println("4. Remove diagnosis from database");
        System.out.println("");
        System.out.println("Select an option");
        int option = scanner.nextInt();
        System.out.println("");
        switch (option) {
            case 1:
                DiagnosisController.addNewDiagnosis();
                break;
            case 2:
                DiagnosisController.editDiagnosisName();
                break;
            case 3:
                DiagnosisController.editDescription();
                break;
            case 4:
                DiagnosisController.deleteDiagnosis();
                break;

            default:
                System.out.println("");
                System.out.println("Invalid option");
                System.out.println("");
        }

        System.out.println("Do you wish to proceed Y/N");
        String endSession = scanner.next().trim();
        System.out.println("");
        if (endSession.equals("Y")) {
            System.out.println("redirecting to main menu");
            System.out.println("");
            mainMenu();

        }

        else{


            System.out.println("End of session. User logout");//log out user
        }




    }

    public  static void adminDrugs(){
        System.out.println("Patient ADMIN menu");
        System.out.println("");
        System.out.println("1. Add drugs");
        System.out.println("2. Edit drugs name");
        System.out.println("3. Edit storage remains");
        System.out.println("4. Delete drug");
        System.out.println("");
        System.out.println("Select an option");
        int option = scanner.nextInt();
        System.out.println("");
        switch (option) {
            case 1:
                DrugController.addNewDrug();
                break;
            case 2:
                DrugController.editDrugsName();
                break;
            case 3:
                DrugController.editDrugsStorage();
                break;
            case 4:
                DrugController.deleteDrug();
                break;

            default:
                System.out.println("");
                System.out.println("Invalid option");
                System.out.println("");
        }

        System.out.println("Do you wish to proceed Y/N");
        String endSession = scanner.next().trim();
        System.out.println("");
        if (endSession.equals("Y")) {
            System.out.println("redirecting to main menu");
            System.out.println("");
            mainMenu();

        }

        else{


            System.out.println("End of session. User logout");//log out user
        }


    }


}
