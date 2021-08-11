package com.company.controlers;

import com.company.dbhelper.DbConnection;
import com.company.objects.Doctor;
import com.company.objects.Drug;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DrugController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewDrug(){

        System.out.println("Enter the drug's name: ");
        String name = scanner.next();
        System.out.println("");

        System.out.println("Enter value in storage: ");
        int storage = scanner.nextInt();
        System.out.println("");

        try {
            ps = DbConnection.user().prepareStatement("INSERT INTO drugs(name, storage)" +
                    "VALUES ('" + name + "', " + storage + ")");

            ps.execute();
            System.out.println("New drug has been added");
            System.out.println("");

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void deleteDrug(){

        int id = getDrugById().getId();

        System.out.println("Do you wish to delete this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if(option.equals("Y")){
            try {

                ps = DbConnection.user().prepareStatement("DELETE FROM drugs WHERE id = " + id);
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

    public static void editDrugsName(){

        int id = getDrugById().getId();

        System.out.println("Do you wish to edit this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if(option.equals("Y")){

                System.out.println("Enter edited name");
                String update = scanner.next().trim();
            System.out.println("");

            try {

                    ps = DbConnection.user().prepareStatement("UPDATE drugs SET name = '"+ update +"' WHERE id =" + id);
                    ps.execute();


                    System.out.println("successfully updated");
                System.out.println("");


            } catch (Exception e) {
                    e.printStackTrace();

                }

        } else{
            System.out.println("Drugs data remains unchanged");
            System.out.println("");
        }

    }

    public static void editDrugsStorage(){

        int id = getDrugById().getId();

        System.out.println("Do you wish to edit this data Y/N");
        String option = scanner.next().trim();
        System.out.println("");
        if(option.equals("Y")){

                System.out.println("Enter edited value");
                int update = scanner.nextInt();
            System.out.println("");

            try {

                    ps = DbConnection.user().prepareStatement("UPDATE drugs SET storage = "+ update +" WHERE id =" + id);
                    ps.execute();


                    System.out.println("successfully updated");
                System.out.println("");


            } catch (Exception e) {
                    e.printStackTrace();
                }

        } else{
            System.out.println("Drugs data remains unchanged");
            System.out.println("");
        }

    }


    public static Drug getDrugById(){

        System.out.println("Enter the drug's id: ");
        int id = scanner.nextInt();
        System.out.println("");

        try {
            ps = DbConnection.user().prepareStatement("SELECT * FROM drugs WHERE id =" + id);
            rs = ps.executeQuery();

            System.out.println("id \t  Name  \t Storage ");

            int drugsID, storage;
            String name;
            Drug drug = new Drug();


            while(rs.next()){

                drugsID = rs.getInt("id");
                

                name = rs.getString("name");
                storage = rs.getInt("storage");
                

                drug.setId(drugsID);


                System.out.println(drugsID + " \t " + name + " \t " + storage);
                System.out.println("");
            }
            return drug;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

}
