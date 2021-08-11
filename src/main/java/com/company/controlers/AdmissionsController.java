package com.company.controlers;

import com.company.dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class AdmissionsController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void newAdmission() {
        System.out.println("Do you wish to add new drug admission to the patient Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {
            int patientID = PatientController.getPatientById().getId();
            int doctorsID = DoctorController.getDoctorById().getId();
            int diagnosisID = DiagnosisController.getDiagnosisById().getId();
            int drugID = DrugController.getDrugById().getId();

            System.out.println("Is data correct? Y/N");
            String conformation = scanner.next().trim();
            if (conformation.equals("Y")) {
                Date date = new Date();
                try {
                    ps = DbConnection.user().prepareStatement("INSERT INTO admissions() VALUES ('" + date + "', " + patientID + ", " + doctorsID + ", " + diagnosisID + ", " + drugID + ")");
                    ps.execute();

                    System.out.println("successfully added to database");


                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Return to main menu");
            }


        } else {
            System.out.println("Return to main menu");
        }


    }

    public static void cancelAdmission() {
        System.out.println("Do you want to cancel drug admission to the patient Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {
            int patientID = PatientController.getPatientById().getId();
            int doctorsID = DoctorController.getDoctorById().getId();
            int diagnosisID = DiagnosisController.getDiagnosisById().getId();
            int drugID = DrugController.getDrugById().getId();

            System.out.println("Is data correct? Y/N");
            String conformation = scanner.next().trim();
            if (conformation.equals("Y")) {

                try {
                    ps = DbConnection.user().prepareStatement("DELETE FROM patients WHERE patient_id = " + patientID + "AND drug_id = " + drugID);
                    ps.execute();

                    System.out.println("Admission canceled");


                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Return to main menu");
            }


        } else {
            System.out.println("Return to main menu");
        }


    }

    public static void reviewAdmissionsByPatient() {
        int patientID = PatientController.getPatientById().getId();

        System.out.println("Do you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {

            try {
                ps = DbConnection.user().prepareStatement("SELECT * FROM drugs WHERE id =" + patientID);
                rs = ps.executeQuery();

                int doctorsID, diagnosisID, drugID;
                String date;


                try {
                    ps = DbConnection.user().prepareStatement("SELECT * FROM patients WHERE id =" + patientID);
                    rs = ps.executeQuery();

                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    String signIn = rs.getString("date_in");


                    System.out.println("Patient " + name + " " + surname + " came on " + signIn);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                System.out.println("Date \t doctorsID \t diagnosisID \t drug name");


                while (rs.next()) {
                    date = rs.getString("date");
                    doctorsID = rs.getInt("doctors_id");
                    diagnosisID = rs.getInt("diagnosis_id");
                    drugID = rs.getInt("drug_id");


                    System.out.println(date + " \t " + doctorsID + " \t " + diagnosisID + " \t\t " + drugID);
                }


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}

