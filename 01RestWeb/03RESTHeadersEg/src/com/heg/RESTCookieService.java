package com.heg;


import java.io.IOException;
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

@Path("/CService")
public class RESTCookieService {
	
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String FAILURE_RESULT="<result>failure</result>";

   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public Response getUsers(){
	   System.out.println("Setting cookie");
	   
	   //use below to set multiple cookies
       //return Response.ok().cookie(new NewCookie("cname", "cvalue"), new NewCookie("cname", "cvalue")).build();
	   return Response.ok().cookie(new NewCookie("cfirst", "ccheck")).cookie(new NewCookie("abc","def")).build();
   }

   @GET
   @Path("/userhp")
   @Produces(MediaType.APPLICATION_XML)
   public Response getCParams(@CookieParam("cname") String cv){
	   
	   System.out.println("in getCParams():"+cv);
       return Response.status(200).entity("successfully got cookie params").build();
   }

}