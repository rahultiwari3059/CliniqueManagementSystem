package com.bridgelabz.databaseManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bridgelabz.model.CliniqueModel;
import com.bridgelabz.model.DoctorModel;
import com.bridgelabz.model.PatientsModel;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DatabaseInsertionDaoImpl implements DatabaseInsertionDao{
	Connection connection;
	
	//constructor for database connection
public	DatabaseInsertionDaoImpl()
	{
		
	MysqlDataSource ds = new MysqlDataSource();
		try {
			ds.setServerName("localhost");
			ds.setPortNumber(3306);
			ds.setDatabaseName("CliniqueManagementSystem");
			ds.setUser("root");
			ds.setPassword("bridgeit");
			connection = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		//creating cliniqueTable 
	public void createCliniqueTable() 
	{
		try {
			PreparedStatement createCliniqueTable = connection
					.prepareStatement("CREATE TABLE CliniqueManagementSystem.Clinique("
							+ "clinique_Id INT NOT NULL,clinique_Name VARCHAR(45) NOT NULL,"
							+ "PRIMARY KEY (clinique_Id))");
			createCliniqueTable.executeUpdate();
		} catch (MySQLSyntaxErrorException e) {
			System.out.println("Table Present! Inserting Information");
		} catch (SQLException e) {
			System.out.println("Error in creating table");
		}

	}


	//creating doctorTable 
	public void createDoctorTable() 
	{
		try {
			PreparedStatement createDoctor = connection
					.prepareStatement("CREATE TABLE doctor(dr_id INT NOT NULL,dr_name VARCHAR(100) NULL,"
							+ "specialization VARCHAR(100) NULL," + "availability VARCHAR(100) NULL,"
							+ "PRIMARY KEY (dr_id))");
			createDoctor.executeUpdate();
		} catch (MySQLSyntaxErrorException e) {
			System.out.println("Table Present! Inserting Information");
		} catch (SQLException e) {
			System.out.println("Error in creating table");
		}
	}

	//create patientTable
	public void createPatientTable() 
	{
		try {
			PreparedStatement createPatient = connection
					.prepareStatement("CREATE TABLE CliniqueManagementSystem.Patient (" + "Patient_Id INT NOT NULL,"
							+ "Patient_Name VARCHAR(45) NULL," + "Patient_Age INT NOT NULL,"
							+ "Patient_MobileNo VARCHAR(45) NULL," + "PRIMARY KEY (Patient_Id),"
							+ "UNIQUE INDEX Patient_MobileNo_UNIQUE (Patient_MobileNo ASC))");
			createPatient.executeUpdate();
		} catch (MySQLSyntaxErrorException e) {
			System.out.println("Table Present! Inserting Information");
		} catch (SQLException e) {
			System.out.println("Error in creating table");
		}
	}
	
	// inserting clinique data data into database 
	public void insertIntoClinique(ArrayList<CliniqueModel> cliniqueModelArrayList)  {
		try{
		String query = " insert into Clinique (clinique_Id,clinique_Name)"
		        + " values (?, ?)";
		
		 // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = connection.prepareStatement(query);
	      
	      for (int i = 0; i < cliniqueModelArrayList.size(); i++) {
	    	  preparedStmt.setInt(1, cliniqueModelArrayList.get(i).getCliniqueId());
	    	  preparedStmt.setString (2, cliniqueModelArrayList.get(i).getCliniqueName());
	    	  // execute the preparedstatement
	    	  preparedStmt.execute();
		}
	     
	     // connection.close();
		}
		catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	}
	
	// inserting doctor data into database 
	public void insertIntoDoctor(ArrayList<DoctorModel> doctorModelArrayListObject) {
		try{
			String query = " insert into doctor (dr_id,dr_name,specialization,availability)"
			        + " values (?, ?,?,?)";
			 // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = connection.prepareStatement(query);
		      for (int i = 0; i < doctorModelArrayListObject.size(); i++) {
		    	  preparedStmt.setInt(1, doctorModelArrayListObject.get(i).getmId());
		    	  preparedStmt.setString(2, doctorModelArrayListObject.get(i).getmDocName());
		    	  preparedStmt.setString(3, doctorModelArrayListObject.get(i).getmSpecialization());
		    	  preparedStmt.setString(4, doctorModelArrayListObject.get(i).getmAvailability());
		    	  // execute the preparedstatement
		    	  preparedStmt.execute();
			}
		     
		      
		}
		catch (Exception e)
	    {
	      System.err.println("Got an exception in doc!");
	      System.err.println(e.getMessage());
	    }
	}
	// inserting patient data into database 
	public void insertIntoPatient(ArrayList<PatientsModel> patientsModelArrayListObject) {
		try {
			String query = " insert into Patient (Patient_Id,Patient_Name,Patient_Age,Patient_MobileNo)"
					+ " values (?,?,?,?)";
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			for (int i = 0; i < patientsModelArrayListObject.size(); i++) {
				preparedStmt.setInt(1, patientsModelArrayListObject.get(i).getmId());
				preparedStmt.setString(2, patientsModelArrayListObject.get(i).getmName());
				preparedStmt.setInt(3, patientsModelArrayListObject.get(i).getmAge());
				preparedStmt.setString(4, patientsModelArrayListObject.get(i).getmMobileNo());
				// execute the preparedstatement
				preparedStmt.execute();
			}
			connection.close();
		} catch (Exception e) {
			System.err.println("Got an exception in patientInsersion!");
			System.err.println(e.getMessage());
		}
	}
}
