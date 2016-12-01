package com.bridgelabz.CliniqueManagementSystem;

import java.util.ArrayList;

import com.bridgelabz.databaseManagement.DatabaseInsertionDaoImpl;
import com.bridgelabz.inputReader.JSONInputReader;
import com.bridgelabz.model.CliniqueModel;
import com.bridgelabz.model.DoctorModel;
import com.bridgelabz.model.PatientsModel;

public class Main {
	
	
	public static void main(String[] args)
	{
		
		// taking command line argument as jsonfile 
		String JSONInputFile= args[0];
		//creating object of JSONInputReader class
		JSONInputReader jsonInputReaderObject= new JSONInputReader();
		
		//creating object of DatabaseInsertionDaoImpl
		DatabaseInsertionDaoImpl DatabaseInsertionDaoImplObject= new DatabaseInsertionDaoImpl();
		
		ArrayList<CliniqueModel> CliniqueModelArrayList =jsonInputReaderObject.cliniqueInfoReader(JSONInputFile);
		ArrayList<DoctorModel> doctorModelArrayListObject =	jsonInputReaderObject.docInfoReader();
		ArrayList<PatientsModel> patientsModelArrayListObject=	jsonInputReaderObject.patientInfoReader();
		//calling createDoctorTable  method 
		DatabaseInsertionDaoImplObject.createDoctorTable();
		// calling DatabaseInsertionDaoImplObject
		DatabaseInsertionDaoImplObject.createCliniqueTable();
		//
		DatabaseInsertionDaoImplObject.createPatientTable();
		DatabaseInsertionDaoImplObject.insertIntoClinique(CliniqueModelArrayList);
		DatabaseInsertionDaoImplObject.insertIntoDoctor(doctorModelArrayListObject);
		DatabaseInsertionDaoImplObject.insertIntoPatient(patientsModelArrayListObject);
	}

}
