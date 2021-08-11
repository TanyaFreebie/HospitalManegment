package com.company.objects;

public class Admission {
    private String date;
    private int patientID;
    private int doctorID;
    private int dosePerDay;
    private int singleDose;

    public Admission(){

    }

    public Admission(String date, int patientID, int doctorID, int dosePerDay, int singleDose) {
        this.date = date;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.dosePerDay = dosePerDay;
        this.singleDose = singleDose;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getDosePerDay() {
        return dosePerDay;
    }

    public void setDosePerDay(int dosePerDay) {
        this.dosePerDay = dosePerDay;
    }

    public int getSingleDose() {
        return singleDose;
    }

    public void setSingleDose(int singleDose) {
        this.singleDose = singleDose;
    }
}
