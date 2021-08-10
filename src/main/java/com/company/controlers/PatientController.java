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
   private static  PreparedStatement ps;
   private static ResultSet rs;
   //database tanya_project table patients

    public static boolean addNewPatient(){

        System.out.println("Enter the patient's name: ");
        String name = scanner.next();

        System.out.println("Enter the patient's surname: ");
        String surname = scanner.next();
        Date date = new Date();



        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO patients(name, surname, date_in)" +
                    "VALUES ('" + name + "', '" + surname + "' , '" +  date + "')");

            ps.execute();
            System.out.println("Patient added to table");

            System.out.println("Do you wish to assign specialist to this patient Y/N?");
            String assigned;
            assigned = scanner.next().trim();
            if(assigned.equals("Y")){
                System.out.println("continue on assign specialist");//assignDoctor
            } else{
                System.out.println("Information has been successfully added");
            }


            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

        public static void deletePatient(){

            int conformation = getPatientById().getId();

            System.out.println("Do you wish to delete this data Y/N");
            String option = scanner.next().trim();
            if(option.equals("Y")){
                System.out.println("Enter patient ID for conformation");
                int id = scanner.nextInt();
               if (id == conformation){ try {

                    ps = DbConnection.user().prepareStatement("DELETE FROM patients WHERE id = " + id);
                    ps.execute();

                    System.out.println("successfully removed to database");


                } catch (Exception e) {
                   e.printStackTrace();
               }
               } else {
                   System.out.println("Conformation failed. Try again");

                }

            } else{
                System.out.println("Patient remained in database");
            }


        }

        public static void editPatientName(){

            int conformation = getPatientById().getId();

            System.out.println("Do you wish to edit this data Y/N");
            String option = scanner.next().trim();
            if(option.equals("Y")){
                System.out.println("Enter patient ID for conformation");
                int id = scanner.nextInt();
                if (id == conformation){

                    System.out.println("Enter edited name");
                    String update = scanner.next().trim();



                    try {

                            ps = DbConnection.user().prepareStatement("UPDATE patients SET name = '"+ update +"' WHERE id =" + id);
                            ps.execute();


                        System.out.println("successfully updated");


                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                } else {
                    System.out.println("Conformation failed. Try again");

                }

            } else{
                System.out.println("Patient data remains unchanged");
            }

        }

        public static void editPatientSurname(){

            int conformation = getPatientById().getId();

            System.out.println("Do you wish to edit this data Y/N");
            String option = scanner.next().trim();
            if(option.equals("Y")){
                System.out.println("Enter patient ID for conformation");
                int id = scanner.nextInt();
                if (id == conformation){

                    System.out.println("Enter edited surname");
                    String update = scanner.next().trim();



                    try {

                        ps = DbConnection.user().prepareStatement("UPDATE patients SET surname = '"+ update +"' WHERE id =" + id);
                        ps.execute();


                        System.out.println("Successfully updated");


                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                } else {
                    System.out.println("Conformation failed. Try again");

                }

            } else{
                System.out.println("Patient data remains unchanged");
            }
        }

    public static void assignSpecialist() {
        int conformation = getPatientById().getId();

        System.out.println("Do you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {
            System.out.println("Enter patient ID for conformation");
            int id = scanner.nextInt();
            if (id == conformation) {
                System.out.println("Choose Specialist:");
                int conformation1 = getDoctorById().getId();

                System.out.println("do you wish to assign this specialist Y/N");
                String option1 = scanner.next().trim();
                if (option1.equals("Y")) {
                    System.out.println("Enter doctors ID for conformation");
                    int id1 = scanner.nextInt();
                    if (id1 == conformation1) {

                        try {

                            ps = DbConnection.user().prepareStatement("UPDATE patients SET doctors_id = " + id1 + " WHERE id =" + id);
                            ps.execute();


                            System.out.println("Successfully updated");


                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    } else {
                        System.out.println("Conformation failed. Try again");

                    }

                } else {
                    System.out.println("Patient data remains unchanged");
                }
            } else {
                System.out.println("Conformation failed. Try again");
            }
        }else {
            System.out.println("Patient data remains unchanged");
    }
}
    public static void dischargeFromHospital(){
        int conformation = getPatientById().getId();

        System.out.println("Do you wish to delete this data Y/N");
        String option = scanner.next().trim();
        if(option.equals("Y")){
            System.out.println("Enter patient ID for conformation");
            int id = scanner.nextInt();
            if (id == conformation){
                Date date = new Date();
                try {

                ps = DbConnection.user().prepareStatement("UPDATE patients SET date_out = '" +  date + "' WHERE id = " + id);

                ps.execute();
                System.out.println("Patient went home");


            } catch (Exception e) {
                e.printStackTrace();
            }
            } else {
                System.out.println("Conformation failed. Try again");

            }

        } else{
            System.out.println("Patient remained in hospital");
        }
    }

    public static Patient getPatientById(){

        System.out.println("Enter the ID of the patient: ");
        int id = scanner.nextInt();



        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM patients WHERE id =" + id);
            rs = ps.executeQuery();

            System.out.println("ID \t  Name  \t  Surname \t  DiagnosisID \t DoctorsID \t Receipt \t \t \t \t \t \t Discharged");

            int patientID, doctorsID, diagnosisID;
            String name, surname, signIn, signOut;
            Patient patient = new Patient();


            while(rs.next()){

                patientID = rs.getInt("id");
                doctorsID =rs.getInt("doctors_id");
                diagnosisID = rs.getInt("diagnosis_id");
                name = rs.getString("name");
                surname = rs.getString("surname");
                signIn = rs.getString("date_in");
                signOut =rs.getString("date_out");
                patient.setId(patientID);


                System.out.println(patientID + " \t " + name + " \t\t " + surname + " \t \t " + diagnosisID + " \t\t\t\t "+ doctorsID + " \t\t\t "+ signIn + " \t "+ signOut);
            }
            return patient;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }



    }


}
