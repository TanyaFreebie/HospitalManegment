//package com.company.controlers.patients;
//
//import com.company.dbhelper.DbConnection;
//import com.company.objects.Patient;
//
//
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import java.util.Date;
//import java.util.Scanner;
//
//public class update {
//    private static Scanner scanner = new Scanner(System.in);
//    private static  PreparedStatement ps;
//    private static ResultSet rs;
//
//    public static void update() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("What would you like to do now?");
//        System.out.println("1. Edit name and surname");
//        System.out.println("2. Assign new doctor");
//        System.out.println("3. Edit diagnosis");
//        System.out.println("4. Add sign out date");
//
//
//        System.out.println("Select an option");
//        int option = scanner.nextInt();
//
//        switch (option) {
//            case 1:
//                PatientController.editName();
//                break;
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
//
//            default:
//                System.out.println("Invalid option");
//
//
//        }
//    }