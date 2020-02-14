package com.patients.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.patients.client.model.Patient;

public class PatientWsClient {
	private static final String PATIENT_SERVICE_URL = "http://localhost:8080/restWs/services/patientservice";

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		// ---------get method-------------
		// static way to do passed the url
		// WebTarget target =
		// client.target("http://localhost:8080/restWs/services/patientservice/patients/1");
		// dynamically we passing the url and binding the id with resolveTemplate
		WebTarget target = client.target(PATIENT_SERVICE_URL).path("/patients").path("/{id}").resolveTemplate("id", 3);
		// invocation builder for different http request
		Builder request = target.request();
		// get response we taking
		Patient patient = request.get(Patient.class);
		System.out.println(patient.getId());
		System.out.println(patient.getName());

		
		// ---------update method-------------------
		patient.setName("maldini");
		WebTarget putTarget = client.target(PATIENT_SERVICE_URL).path("/patients");
		Response updateResponse = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
		System.out.println(updateResponse.getStatus());
		// clean up activity
		updateResponse.close();

		
		// ----------create method-----------
		patient.setName("roben");
		WebTarget createPath = client.target(PATIENT_SERVICE_URL).path("/patients");
		Patient createPatient = createPath.request().post(Entity.entity(patient, MediaType.APPLICATION_XML),
				Patient.class);
		System.out.println("patient updated :" + createPatient.getId());

		
		// ------delete method----------
		WebTarget deleteTarget = client.target(PATIENT_SERVICE_URL).path("/patients").path("/{id}")
				.resolveTemplate("id", 5);
		Response delete = deleteTarget.request().delete();
		//Response is a static method access in a static way
		System.out.println(Response.status(200));
        delete.close();
		
		
		// clean up all socket
		client.close();
	}
}
