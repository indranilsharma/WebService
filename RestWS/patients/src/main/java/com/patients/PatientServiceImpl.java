package com.patients;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.patients.excption.PatientBusinessException;
import com.patients.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	// creating in-memory map
	Map<Long, Patient> patients = new HashMap<>();
	long currentId = 1;

	public PatientServiceImpl() {
		init();
	}

	// creating init method for clean up the code
	public void init() {
		Patient patient = new Patient();
		patient.setId(currentId);
		patient.setName("Desuza");
		// gating the id from patient object and set patient object as a value of map
		patients.put(patient.getId(), patient);
	}

	@Override
	public List<Patient> getPatients() {
		// retrieving the result
		Collection<Patient> results = patients.values();
		// convert it to list
		List<Patient> response = new ArrayList<>(results);
		// return response
		return response;
	}

	@Override
	public Patient getPatient(Long id) {
		if(patients.get(id)==null) {
			//throw new WebApplicationException(Response.Status.NOT_FOUND);
			//using testing purpose just is it working or not
			throw new WebApplicationException(Response.Status.GATEWAY_TIMEOUT);
		}
		
		return patients.get(id);
	}

	@Override
	public Response createPatient(Patient patient) {

		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		// patient object serialized and response backed
		return Response.ok(patient).build();
	}

	@Override
	public Response updatePatient(Patient patient) {
		Patient currentPatient = patients.get(patient.getId());

		Response response;
		if (currentPatient != null) {
			patients.put(patient.getId(), patient);
			response = Response.ok().build();
		} else {
			 throw new PatientBusinessException();
			//response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deletePatient(long id) {

		Patient patient = patients.get(id);

		Response response;

		if (patient != null) {
			patients.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}
}
