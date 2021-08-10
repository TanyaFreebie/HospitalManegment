package com.company.objects;

public class Patient {

    private int id;
    private String name;
    private String surname;
    private int doctorID;
    private int diagnosisID;

    public Patient(){

    }

    public Patient(int id, String name, String surname, int doctorID, int diagnosisID) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.doctorID = doctorID;
        this.diagnosisID = diagnosisID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getDiagnosisID() {
        return diagnosisID;
    }

    public void setDiagnosisID(int diagnosisID) {
        this.diagnosisID = diagnosisID;
    }
}
