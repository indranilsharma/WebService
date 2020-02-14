package com.patients.passengerService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.patients.passengerService.model.Passenger;

@Path("/passengerservice")
@Produces("application/xml")
@Consumes("application/xml,application/x-www-form-urlencoded")

public interface PassengerService {

	@Path("/passengers")
	@GET
	List<Passenger> getPassenger(@QueryParam("start") int start, @QueryParam("size") int size);

	/*
	 * @Path("/passengers")
	 * 
	 * @POST Passenger addPassenger(Passenger passenger);
	 */

	/*
	 * //@formparam uses "firstName" and "lastName" use at postman
	 * "x-www-form-urlencoded" in body
	 * 
	 * @Path("/passengers")
	 * 
	 * @POST void addPassenger(@FormParam("firstName")String
	 * firstName,@FormParam("lastName")String lastName);
	 */

	/*
	 * // @headerparam uses "agent" and we have to set it in header section in
	 * postman
	 * 
	 * @Path("/passengers")
	 * 
	 * @POST void addPassenger(@FormParam("firstName") String
	 * firstName, @FormParam("lastName") String lastName,
	 * 
	 * @HeaderParam("agent") String agent);
	 */

	/*
	 * @headerparam uses "agent" and we have to set it in header section in postman
	 * HttpHeaders are call all http header
	 */
	@Path("/passengers")
	@POST
	void addPassenger(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
			@HeaderParam("agent") String agent, @Context HttpHeaders headers);

}
