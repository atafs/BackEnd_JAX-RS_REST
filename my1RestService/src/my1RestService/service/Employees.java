package my1RestService.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import my1RestService.model.Employee;

@Path("employees")
public class Employees {

	@GET
	public String getEmployeeNames(@QueryParam("sortBy") String sortedBy) {
		//BAD_REQUEST
		if (sortedBy == null) {
			throw new WebApplicationException(Response
					.status(Response.Status.BAD_REQUEST)
					.header("x-error-message","MESSAGE=sortBy is Mandatory")
					.build());
		}
		//ANOTHER
		if (sortedBy.equals("xxx")) {
			//do something
		}
		//RESULT
		return "Americo, Tomas, Ana, Batalha, xxx " + "sorted by " + sortedBy;
	}

	@GET
	@Path("id/{identifier: [0-9]*}") // reg expression for only numbers
	public String getById(@PathParam("identifier") String myId) {
		return myId;
	}

	@GET
	@Path("xml")
	@Produces("text/xml")
	public Employee getXml() {
		return new Employee(Integer.valueOf(1), "AmericoTomas");
	}

	@GET
	@Path("json")
	@Produces("application/json")
	public Employee getJson() {
		return new Employee(Integer.valueOf(1), "AmericoTomas");
	}

	@GET
	@Path("status")
	public Response getResponse() {
		return Response.notModified().build();
	}
}