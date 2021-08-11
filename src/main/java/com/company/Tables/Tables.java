package com.company.Tables;

public class Tables {
    /*

    ++++DOCTORS+++
CREATE TABLE doctors (
	id INT auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	surname varchar(100) NOT NULL,
	speciality varchar(100) NOT NULL,
	CONSTRAINT doctors_pk PRIMARY KEY (id));

ALTER TABLE doctors
 speciality varchar(100) NOT NULL;

    ++++DRUGS++++
CREATE TABLE drugs (
	id INT auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	storage INT NULL,   //+++++NEW COLUMN ADDED
	CONSTRAINT drugs_pk PRIMARY KEY (id));
)

    ++++DIAGNOSIS+++
    CREATE TABLE diagnosis (
	id INT auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	description varchar(100) NULL,
	CONSTRAINT diagnosis_pk PRIMARY KEY (id));
)

    ++++PATIENTS++++
CREATE TABLE patients (
	id INT auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	surname varchar(100) NOT NULL,
	doctors_id INT NULL,
	diagnosis_id INT NULL,
	date_in VARCHAR(50) NOT NULL,
	date_out VARCHAR(50) NULL,
	CONSTRAINT Patients_pk PRIMARY KEY (id),
	CONSTRAINT patients_FK FOREIGN KEY (doctors_id) REFERENCES doctors(id) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT patients_FK_1 FOREIGN KEY (diagnosis_id) REFERENCES diagnosis(id) ON DELETE SET NULL ON UPDATE CASCADE);

)
     ++++ADMISSIONS++++//added diagnosis!

 CREATE TABLE admissions (
	date VARCHAR(50) NOT NULL,
	patient_id INT NOT NULL,
	diagnosis_id INT NOT NULL,
	drug_id INT NOT NULL,
	doctors_id INT NULL,
	CONSTRAINT admissions_pk PRIMARY KEY (date, patient_id),
	CONSTRAINT admissions_FK FOREIGN KEY (drug_id) REFERENCES drug(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT admissions_FK_1 FOREIGN KEY (doctors_id) REFERENCES doctors(id) ON DELETE SET NULL ON UPDATE CASCADE,

ALTER TABLE admissions
ADD FOREIGN KEY (diagnosis_id) REFERENCES diagnosis(id) ON DELETE SET CASCADE ON UPDATE CASCADE);
     */
}
