package com.company.Tables;

public class Tables {
    /*

    ++++DOCTORS+++
CREATE TABLE tanya_project.doctors (
	id INT auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	surname varchar(100) NOT NULL,
	specialty varchar(100) NOT NULL,
	CONSTRAINT doctors_pk PRIMARY KEY (id)
)

    ++++DRUGS++++
CREATE TABLE tanya_project.drugs (
	id INT auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	CONSTRAINT drugs_pk PRIMARY KEY (id)
)

    ++++DIAGNOSIS+++
    CREATE TABLE tanya_project.diagnosis (
	id INT auto_increment NOT NULL,
	name varchar(100) NULL,
	description varchar(100) NULL,
	CONSTRAINT diagnosis_pk PRIMARY KEY (id)
)

    ++++PATIENTS++++
    CREATE TABLE tanya_project.patients (
	id INT auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	surname varchar(100) NOT NULL,
	doctors_id INT NULL,
	diagnosis_id INT NULL,
	date_in DATE NOT NULL,
	date_out DATE NULL,
	Active varchar(1) NOT NULL,
	CONSTRAINT Patients_pk PRIMARY KEY (id),
	CONSTRAINT patients_FK FOREIGN KEY (doctors_id) REFERENCES tanya_project.doctors(id) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT patients_FK_1 FOREIGN KEY (diagnosis_id) REFERENCES tanya_project.diagnosis(id) ON DELETE SET NULL ON UPDATE CASCADE;

)
     ++++ADMISSIONS++++

 CREATE TABLE tanya_project.admissions (
	date DATE NOT NULL,
	patient_id INT NOT NULL,
	drug_id INT NOT NULL,
	doctors_id NULL,
	dose_per_day INT NOT NULL,
	single_dose INT NOT NULL,
	Active varchar(1) NOT NULL,
	CONSTRAINT admissions_pk PRIMARY KEY (date, patient_id),
	CONSTRAINT admissions_FK FOREIGN KEY (drug_id) REFERENCES tanya_project.drug(id) ON DELETE CASCADE ON UPDATE CASCADE
	CONSTRAINT admissions_FK_1 FOREIGN KEY (doctors_id) REFERENCES tanya_project.doctors(id) ON DELETE SET NULL ON UPDATE CASCADE;
     */
}
