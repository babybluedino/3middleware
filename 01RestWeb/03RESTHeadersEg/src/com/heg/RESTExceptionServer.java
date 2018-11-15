package com.heg;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
class UserNotFoundMapper implements
        ExceptionMapper<UserNotFoundException> {
    @Override
    public Response toResponse(UserNotFoundException ex) {
        return Response.status(404).entity(ex.getMessage()).type("text/plain")
                .build();
    }
    
    /*
     EmpNotFoundException empNotFoundException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorId(empNotFoundException.getErrorId());
		errorResponse.setErrorCode(empNotFoundException.getMessage());
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
				errorResponse).type(
				MediaType.APPLICATION_XML).build();
     */
}

class UserNotFoundException extends Exception implements Serializable{
    @Override
    public String getMessage()
    {
    	return "UserNotFoundException has caused";
    }
}

@Path("/EService")
public class RESTExceptionServer {
	
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String FAILURE_RESULT="<result>failure</result>";

   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public Response getUsers() throws UserNotFoundException{
	   System.out.println("throwing UserNotFoundException");
	   
	   if(true)
	   {
		   throw new UserNotFoundException();
	   }
	   
	   return Response.ok().build();
   }

}
