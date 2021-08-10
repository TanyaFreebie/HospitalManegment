package com.company.controlers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateDb {

    private static Scanner scanner = new Scanner(System.in);
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
        System.out.println("1. Edit name");
        System.out.println("2. Edit surname");
        System.out.println("3. Assign new doctor");
        System.out.println("4. Add diagnosis");
        System.out.println("5. Add sign out date");

        System.out.println("Select an option");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                PatientController.editPatientName();
                break;
            case 2:
                PatientController.editPatientSurname();
                break;
            case 3:
                PatientController.assignSpecialist();
                break;
            case 4:

                break;
            case 5:
                PatientController.dischargeFromHospital();
                break;

            default:
                System.out.println("Invalid option");


        }

    }
}