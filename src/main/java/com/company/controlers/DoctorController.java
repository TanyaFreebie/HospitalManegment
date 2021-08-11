package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.objects.Doctor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DoctorController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewDoctor() {

        System.out.println("Enter the doctor's name: ");
        String name = scanner.next();

        System.out.println("Enter the doctor's surname: ");
        String surname = scanner.next();

        System.out.println("Enter the doctor's speciality: ");
        String speciality = scanner.next();


        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO doctors(name, surname, speciality)" +
                    "VALUES ('" + name + "', '" + surname + "' , '" + speciality + "')");

            ps.execute();
            System.out.println("New doctor has been added");

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void deleteDoctor() {

        int id = getDoctorById().getId();

        System.out.println("Do you wish to delete this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {

            try {
                ps = DbConnection.user().prepareStatement("DELETE FROM doctors WHERE id = " + id);
                ps.execute();

                System.out.println("successfully removed to database");


            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            System.out.println("Patient remained in database");
        }


    }

    public static void editDoctorsName() {

        int id = getDoctorById().getId();

        System.out.println("Do you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter edited name");
            String update = scanner.next().trim();


            try {

                ps = DbConnection.user().prepareStatement("UPDATE doctors SET name = '" + update + "' WHERE id =" + id);
                ps.execute();


                System.out.println("successfully updated");


            } catch (Exception e) {
                e.printStackTrace();

            }


        } else {
            System.out.println("Doctors data remains unchanged");
        }

    }

    public static void editDoctorsSurname() {

        int id = getDoctorById().getId();

        System.out.println("Do you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter edited surname");
            String update = scanner.next().trim();


            try {

                ps = DbConnection.user().prepareStatement("UPDATE doctors SET surname = '" + update + "' WHERE id =" + id);
                ps.execute();


                System.out.println("Successfully updated");


            } catch (Exception e) {
                e.printStackTrace();

            }


        } else {
            System.out.println("Doctors data remains unchanged");
        }
    }

    public static void editDoctorsSpeciality() {

        int id = getDoctorById().getId();

        System.out.println("Do you wish to edit this data Y/N");
        String option = scanner.next().trim();
        if (option.equals("Y")) {


            System.out.println("Enter edited speciality");
            String update = scanner.next().trim();


            try {

                ps = DbConnection.user().prepareStatement("UPDATE doctors SET speciality = '" + update + "' WHERE id =" + id);
                ps.execute();


                System.out.println("Successfully updated");


            } catch (Exception e) {
                e.printStackTrace();

            }


        

    } else{


        System.out.println("Doctors data remains unchanged");
    }

}



    public static Doctor getDoctorById(){

        System.out.println("Enter the ID of the doctor: ");
        int id = scanner.nextInt();



        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM doctors WHERE id =" + id);
            rs = ps.executeQuery();

            System.out.println("ID \t  Name  \t  Surname \t  Speciality ");

            int doctorsID;
            String name, surname, speciality;
            Doctor doctor = new Doctor();


            while(rs.next()){

                doctorsID = rs.getInt("id");

                name = rs.getString("name");
                surname = rs.getString("surname");
                speciality = rs.getString("speciality");

               doctor.setId(doctorsID);


                System.out.println(doctorsID + " \t " + name + " \t " + surname + " \t\t " + speciality);
            }
            return doctor;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }



    }



}
