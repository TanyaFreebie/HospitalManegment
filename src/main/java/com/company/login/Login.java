package com.company.login;

import com.company.controlers.UpdateDb;
import com.company.dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;
    //table users


    public static void userLogin() {
        System.out.println("Sing in");//Welcome message

        //request username from user
        System.out.println("Enter your username: ");
        String login = scanner.next().trim();



        try {
          ps = DbConnection.user().prepareStatement("SELECT * FROM users WHERE username = '" + login + "';");

            rs = ps.executeQuery();

            //set variable for validation
            String  passwordCheck;


         // Check if provided username exists in database
            if (rs.next()) {
                System.out.println("Username excepted.");

                //asking for password from user
                System.out.println("Enter your password: ");
                String password = scanner.next().trim();

                passwordCheck = rs.getString("password");

                //Check if password is correct
                boolean correct = password.equals(passwordCheck);
                if(correct) {
                        System.out.println("Access granted.");
                    } else {
                        System.out.println("Login failed. Check password");
                    }
                } else {
                System.out.println("Username doesn't exists");

            }
            UpdateDb.mainMenu();



        } catch (Exception e) {
            e.printStackTrace();

        }
    }



    }//end of test

