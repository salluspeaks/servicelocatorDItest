import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/")
public class TestResource {
	@Inject
	@Named("mapper")
	private ObjectMapper mapper;
	
	@Inject
	@Named("interface")
	private InterfaceTest interfaceobject;
	
	
	
/*	@GET
	@Path("/test/{name}")
	public Response testresource(@PathParam("name")String name) throws JsonProcessingException{
		User user= new User();
	user.setName(name);	
		
		return Response.status(200).entity(mapper.writeValueAsString(user)).build();	
		
		
	}*/
	
	@GET
	@Path("/test/{name}")
	public Response testresource(@PathParam("name")String name) throws JsonProcessingException{
			
		
		return Response.status(200).entity(name).build();	
		
		
	}

}
