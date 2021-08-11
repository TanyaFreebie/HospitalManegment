package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.objects.Diagnosis;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DiagnosisController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewDiagnosis(){

        System.out.println("Enter the diagnosis short label: ");
        String name = scanner.next();
        System.out.println("");

        System.out.println("Enter description: ");
        String description = scanner.next().trim();
        System.out.println("");

        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO diagnosis(name, description)" +
                    "VALUES ('" + name + "', '" + description + "')");

            ps.execute();
            System.out.println("New diagnosis has been added");
            System.out.println("");

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void deleteDiagnosis(){

        int id = getDiagnosisById().getId();

        System.out.println("Do you wish to delete this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if(option.equals("Y")){
            try {

                ps = DbConnection.user().prepareStatement("DELETE FROM diagnosis WHERE id = " + id);
                ps.execute();

                System.out.println("successfully removed to database");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();
            }

        } else{
            System.out.println("Data remained unchanged");
            System.out.println("");
        }


    }

    public static void editDiagnosisName(){

        int id = getDiagnosisById().getId();

        System.out.println("Do you wish to edit this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if(option.equals("Y")){

            System.out.println("Enter edited short description");
            String update = scanner.next().trim();
            System.out.println("");

            try {

                ps = DbConnection.user().prepareStatement("UPDATE diagnosis SET name = '"+ update +"' WHERE id =" + id);
                ps.execute();


                System.out.println("successfully updated");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();

            }

        } else{
            System.out.println("diagnosis data remains unchanged");
            System.out.println("");
        }

    }

    public static void editDescription(){

        int id = getDiagnosisById().getId();

        System.out.println("Do you wish to edit this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if(option.equals("Y")){

            System.out.println("Enter edited description");
            String update = scanner.next().trim();
            System.out.println("");

            try {

                ps = DbConnection.user().prepareStatement("UPDATE diagnosis SET description = "+ update +" WHERE id =" + id);
                ps.execute();


                System.out.println("successfully updated");
                System.out.println("");


            } catch (Exception e) {
                e.printStackTrace();
            }

        } else{
            System.out.println("data remains unchanged");
            System.out.println("");
        }

    }


    public static Diagnosis getDiagnosisById(){

        System.out.println("Enter the diagnosis's id: ");
        int id = scanner.nextInt();
        System.out.println("");



        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM diagnosis WHERE id =" + id);
            rs = ps.executeQuery();

            System.out.println("id \t  Name  \t description ");

            int diagnosisID;
            String description, name;
            Diagnosis diagnosis = new Diagnosis();


            while(rs.next()){

                diagnosisID = rs.getInt("id");
                name = rs.getString("name");
                description = rs.getString("description");

                diagnosis.setId(diagnosisID);


                System.out.println(diagnosisID + " \t " + name + " \t " + description);
                System.out.println("");
            }
            return diagnosis;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
}
