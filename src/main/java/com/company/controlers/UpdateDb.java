package com.company.controlers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateDb {

    private static final Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to do now?");
        System.out.println("1. Patients");
        System.out.println("2. Doctors");
        System.out.println("3. Diagnosis");
        System.out.println("4. Drugs");
        System.out.println("5. Admissions");

        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                updatePatient();
                break;
//            case 2:
//
//                break;
//            case 3:
//
//                break;
//            case 4:
//
//                break;
//            case 5:
//
//                break;

            default:
                System.out.println("Invalid option");
        }


    }

    public static void updatePatient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to do now?");
        System.out.println("1. Add new patient");
        System.out.println("2. Edit name");
        System.out.println("3. Edit surname");
        System.out.println("4. Assign new doctor");
        System.out.println("5. Add patients diagnosis");
        System.out.println("6. Add patient admissions");
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

                break;
            case 6:

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

    }
}