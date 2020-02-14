package com.patients.excption;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class PatientBusinessExceptionMapper implements ExceptionMapper<PatientBusinessException> {
     
	@Override
	public Response toResponse(PatientBusinessException e) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("{");
		sb.append("\"status\":\"error\"");
		sb.append(",");
		sb.append("\"message\":\"user not present\"");
		sb.append("}");

		
		//by the entity we telling custom exception object  and sending the type
		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
		
		//custom exception code
		//return Response.status(222).build();
	}

}
