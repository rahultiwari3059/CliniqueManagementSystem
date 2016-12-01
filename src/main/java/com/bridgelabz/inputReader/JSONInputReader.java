package com.bridgelabz.inputReader;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.model.CliniqueModel;
import com.bridgelabz.model.DoctorModel;
import com.bridgelabz.model.PatientsModel;

public class JSONInputReader {
	static String JsonFilePath;
	
	public ArrayList<CliniqueModel> cliniqueInfoReader(String PJsonFilePath) {
		JsonFilePath = PJsonFilePath;

		// creating object of ArrayList of cliniqueModel
		ArrayList<CliniqueModel> CliniqueModelArrayList = new ArrayList<CliniqueModel>();
		try {
			JSONParser parser = new JSONParser();

			// parsing and casting to Object
			Object obj = parser.parse(new FileReader(JsonFilePath));

			// casting object into JSONObject
			JSONObject jsonObject = (JSONObject) obj;

			/*******************
			 * taking clinic info
			 *****************************************/
			// casting into jsonArray
			JSONArray clinicJsonArray = (JSONArray) jsonObject.get("Clinic");

			for (int i = 0; i < clinicJsonArray.size(); i++) {

				CliniqueModel cliniqueModelObject = new CliniqueModel();
				Object clinicarrayObject = clinicJsonArray.get(i);
				// casting object into JSONObject
				JSONObject clinicJsonObject = (JSONObject) clinicarrayObject;

				// setting data into clinique model
				cliniqueModelObject.setCliniqueName((String) clinicJsonObject.get("Name"));
				cliniqueModelObject.setCliniqueId(Integer.parseInt(String.valueOf(clinicJsonObject.get("ClinicId"))));
				CliniqueModelArrayList.add(cliniqueModelObject);
				System.out.println(cliniqueModelObject.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return CliniqueModelArrayList;
	}

public ArrayList<DoctorModel> docInfoReader() {
		// creating ArrayList of DoctorModel
		ArrayList<DoctorModel> doctorModelArrayListOvject = new ArrayList<DoctorModel>();

		try {
			JSONParser parser = new JSONParser();

			// parsing and casting to Object
			Object obj = parser.parse(new FileReader(JsonFilePath));

			// casting object into JSONObject
			JSONObject jsonObject = (JSONObject) obj;
			/*****************************************
			 * * reading doctors info
			 *****************/
			// casting into jsonArray
			JSONArray doctorJsonArray = (JSONArray) jsonObject.get("Doctors");

			for (int j = 0; j < doctorJsonArray.size(); j++) {
				// creating object of DoctorModel
				DoctorModel doctorModelObject = new DoctorModel();

				// taking first value
				Object doctorArrayObject = doctorJsonArray.get(j);

				// casting object into JSONObject
				JSONObject doctorJSONArrayObject = (JSONObject) doctorArrayObject;
				// setting value to the doctor model object
			//	doctorModelObject.setmAvailability((String) doctorJSONArrayObject.get("Availability"));

				JSONArray clinicIdJsonArray = (JSONArray) doctorJSONArrayObject.get("Clinic");

				ArrayList<String> clinicIdArrayList = new ArrayList<String>();
				ArrayList<String> availabilityArrayList = new ArrayList<String>();
				for (int k = 0; k < clinicIdJsonArray.size(); k++) {
					JSONObject clinicsObject = (JSONObject) clinicIdJsonArray.get(k);
					String clinicId1 = (String) clinicsObject.get("ClinicID");
					String availability = (String) clinicsObject.get("Availability");
					clinicIdArrayList.add(clinicId1);
					availabilityArrayList.add(availability);
				}

				doctorModelObject.setClinicId(clinicIdArrayList);
				doctorModelObject.setAvailability(availabilityArrayList);
				doctorModelObject.setmDocName((String) doctorJSONArrayObject.get("Name"));
				doctorModelObject.setmSpecialization((String) doctorJSONArrayObject.get("Specialization"));
				int idInfo = Integer.parseInt(String.valueOf(doctorJSONArrayObject.get("DoctID")));
				doctorModelObject.setmId(idInfo);
				doctorModelArrayListOvject.add(doctorModelObject);
				System.out.println(doctorModelObject.toString());

			}
			System.out.println(doctorModelArrayListOvject);
		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return doctorModelArrayListOvject;
	}

public ArrayList<PatientsModel> patientInfoReader() {
		// creating arrayList of petientModel
		ArrayList<PatientsModel> patientsModelArrayListObject = new ArrayList<PatientsModel>();

		JSONParser parser = new JSONParser();

		try {

			// parsing and casting to Object
			Object obj = parser.parse(new FileReader(JsonFilePath));

			// casting object into JSONObject
			JSONObject jsonObject = (JSONObject) obj;

			/*********************
			 * taking patients info
			 ****************************/
			// casting into jsonArray
			JSONArray PatientsJSONArray = (JSONArray) jsonObject.get("Patients");
			// System.out.println(PatientsJSONArray);

			for (int p = 0; p < PatientsJSONArray.size(); p++) {
				// creating object of model class
				PatientsModel patientsModelObject = new PatientsModel();

				// taking first value
				Object petientArrayObject = PatientsJSONArray.get(p);
				// casting object into JSONObject

				JSONObject patientJSONArrayObject = (JSONObject) petientArrayObject;

				patientsModelObject.setmMobileNo((String) patientJSONArrayObject.get("MobileNo"));

				JSONArray clinicIdJsonArray = (JSONArray) patientJSONArrayObject.get("ClinicId");

				ArrayList<String> clinicId = new ArrayList<String>();

				for (int k = 0; k < clinicIdJsonArray.size(); k++) {

					clinicId.add((String) clinicIdJsonArray.get(k));

				}
				patientsModelObject.setmPatientsClinicId(clinicId);
				patientsModelObject.setmId(Integer.parseInt(String.valueOf(patientJSONArrayObject.get("PatientId"))));
				int patientAge = Integer.parseInt(String.valueOf(patientJSONArrayObject.get("Age")));
				patientsModelObject.setmAge(patientAge);
				patientsModelObject.setmName((String) patientJSONArrayObject.get("Name"));
				System.out.println(patientsModelObject.toString());
				patientsModelArrayListObject.add(patientsModelObject);
			}
		}

		catch (Exception e) {

			e.printStackTrace();
		}
		return patientsModelArrayListObject;
	}

}
