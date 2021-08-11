package com.company;


import com.company.controlers.DoctorController;
import com.company.controlers.DrugController;
import com.company.controlers.PatientController;
import com.company.controlers.UpdateDb;
import com.company.dbhelper.DbConnection;
import com.company.objects.Doctor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args){
        PreparedStatement ps;

        //find a way to add a recursion if there was mistake and end recursion on command


        //add admissions and UpdateDb - case menu - main menu leads to doctors/parients/drug/admission menu

        //add users access to menu after login conformation


        //Hardcoding on filling up database
//        try {
//            ps = DbConnection.user().prepareStatement("INSERT INTO drugs(name, storage)" +
//                    "VALUES ('vitamins', " + 200 + ")");
//
//            ps.execute();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
