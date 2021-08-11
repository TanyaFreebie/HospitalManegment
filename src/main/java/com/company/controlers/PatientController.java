package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.objects.Patient;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;
import java.util.Scanner;

import static com.company.controlers.DoctorController.getDoctorById;

public class PatientController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;
    //database tanya_project table patients

    public static void addNewPatient() {

        System.out.println("Enter the patient's name: ");
        String name = scanner.next();
        System.out.println("");

        System.out.println("Enter the patient's surname: ");
        String surname = scanner.next();
        System.out.println("");
        Date date = new Date();


        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO patients(name, surname, date_in)" +
                    "VALUES ('" + name + "', '" + surname + "' , '" + date + "')");

            ps.execute();
            System.out.println("Patient added to table");
            System.out.println("");

            System.out.println("Do you wish to assign specialist to this patient Y/N?");
            String assigned;
            assigned = scanner.next().trim();
            System.out.println("");
            if (assigned.equals("Y")) {
                System.out.println("continue on assign specialist");
                PatientController.assignSpecialist();
            } else {
                System.out.println("Information has been successfully added");
                System.out.println("");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletePatient() {

        int id = getPatientById().getId();

        System.out.println("Do you wish to delete this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if (option.equals("Y")) {
            try {

                ps = DbConnection.user().prepareStatement("DELETE FROM patients WHERE id = " + id);
                ps.execute();

                System.out.println("successfully removed to database");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            System.out.println("Patient remained in database");
            System.out.println("");
        }


    }

    public static void editPatientName() {

        int id = getPatientById().getId();

        System.out.println("Do you wish to edit this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if (option.equals("Y")) {


            System.out.println("Enter edited name");
            String update = scanner.next().trim();
            System.out.println("");


            try {

                ps = DbConnection.user().prepareStatement("UPDATE patients SET name = '" + update + "' WHERE id =" + id);
                ps.execute();


                System.out.println("successfully updated");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();

            }


        } else {
            System.out.println("Patient data remains unchanged");
            System.out.println("");
        }

    }

    public static void editPatientSurname() {

        int id = getPatientById().getId();

        System.out.println("Do you wish to edit this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if (option.equals("Y")) {


            System.out.println("Enter edited surname");
            String update = scanner.next().trim();
            System.out.println("");


            try {

                ps = DbConnection.user().prepareStatement("UPDATE patients SET surname = '" + update + "' WHERE id =" + id);
                ps.execute();


                System.out.println("Successfully updated");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();

            }


        } else {
            System.out.println("Patient data remains unchanged");
            System.out.println("");
        }
    }

    public static void assignDiagnosis() {
        int id = getPatientById().getId();

        System.out.println("Do you wish to edit this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if (option.equals("Y")) {

            System.out.println("Choose diagnosis:");
            int id1 = DiagnosisController.getDiagnosisById().getId();

            System.out.println("do you wish to assign this specialist Y/N");
            String option1 = scanner.next().trim();
            System.out.println("");
            if (option1.equals("Y")) {


                try {

                    ps = DbConnection.user().prepareStatement("UPDATE patients SET diagnosis_id = " + id1 + " WHERE id =" + id);
                    ps.execute();


                    System.out.println("Successfully updated");
                    System.out.println("");


                } catch (Exception e) {
                    e.printStackTrace();

                }


            } else {
                System.out.println("Patient data remains unchanged");
                System.out.println("");
            }

        } else {
            System.out.println("Patient data remains unchanged");
            System.out.println("");
        }
    }

    public static void assignSpecialist() {
        int id = getPatientById().getId();

        System.out.println("Do you wish to edit this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if (option.equals("Y")) {

            System.out.println("Choose Specialist:");
            int id1 = getDoctorById().getId();
            System.out.println("");

            System.out.println("do you wish to assign this specialist Y/N");
            String option1 = scanner.next().trim();
            System.out.println("");
            if (option1.equals("Y")) {


                try {

                    ps = DbConnection.user().prepareStatement("UPDATE patients SET doctors_id = " + id1 + " WHERE id =" + id);
                    ps.execute();


                    System.out.println("Successfully updated");
                    System.out.println("");


                } catch (Exception e) {
                    e.printStackTrace();

                }


            } else {
                System.out.println("Patient data remains unchanged");
                System.out.println("");
            }

        } else {
            System.out.println("Patient data remains unchanged");
            System.out.println("");
        }
    }

    public static void dischargeFromHospital() {
        int id = getPatientById().getId();

        System.out.println("Do you wish to delete this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if (option.equals("Y")) {

            Date date = new Date();
            try {

                ps = DbConnection.user().prepareStatement("UPDATE patients SET date_out = '" + date + "' WHERE id = " + id);

                ps.execute();
                System.out.println("Patient went home");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            System.out.println("Patient remained in hospital");
            System.out.println("");
        }
    }

    public static Patient getPatientById() {

        System.out.println("Enter the ID of the patient: ");
        int id = scanner.nextInt();
        System.out.println("");


        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM patients WHERE id =" + id);
            rs = ps.executeQuery();
            System.out.println("");

            System.out.println("ID \t  Name  \t  Surname \t  DiagnosisID \t DoctorsID \t Receipt \t \t \t \t \t \t Discharged");

            int patientID, doctorsID, diagnosisID;
            String name, surname, signIn, signOut;
            Patient patient = new Patient();


            while (rs.next()) {

                patientID = rs.getInt("id");
                doctorsID = rs.getInt("doctors_id");
                diagnosisID = rs.getInt("diagnosis_id");
                name = rs.getString("name");
                surname = rs.getString("surname");
                signIn = rs.getString("date_in");
                signOut = rs.getString("date_out");
                patient.setId(patientID);


                System.out.println(patientID + " \t " + name + " \t\t " + surname + " \t \t " + diagnosisID + " \t\t\t\t " + doctorsID + " \t\t\t " + signIn + " \t " + signOut);
                System.out.println("");
            }
            return patient;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }


    }


}
