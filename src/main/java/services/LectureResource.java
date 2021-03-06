package services;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

@Path("/lecture")
public interface LectureResource {
	   @POST
	   @Consumes("application/xml")
	   Response createEmployee(InputStream is);


	   @GET
	   @Path("{id}")
	   @Produces("application/xml")
	   StreamingOutput retrieveEmployee(@PathParam("id") int id);

	   @PUT
	   @Path("{id}")
	   @Consumes("application/xml")
	   void updateEmployee(@PathParam("id") int id, InputStream is);
}
