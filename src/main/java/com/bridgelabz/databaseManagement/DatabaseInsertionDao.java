package com.bridgelabz.databaseManagement;

import java.util.ArrayList;

import com.bridgelabz.model.CliniqueModel;
import com.bridgelabz.model.DoctorModel;
import com.bridgelabz.model.PatientsModel;

public interface DatabaseInsertionDao {
	public void createCliniqueTable();
	public void createDoctorTable();
	public void createPatientTable();
	public void insertIntoClinique(ArrayList<CliniqueModel> CliniqueModelArrayList);
	public void insertIntoDoctor(ArrayList<DoctorModel> doctorModelArrayListObject);
	public void insertIntoPatient(ArrayList<PatientsModel> patientsModelArrayListObject);

}
