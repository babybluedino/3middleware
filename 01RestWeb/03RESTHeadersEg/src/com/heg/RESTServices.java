package com.heg;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
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
import javax.ws.rs.core.Response;

@Path("/EgService")
public class RESTServices {
	
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String FAILURE_RESULT="<result>failure</result>";

   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getUsers(@Context HttpHeaders hdrs){
	   Set<String> headerKeys = hdrs.getRequestHeaders().keySet();
       for(String header:headerKeys){
           System.out.println(header+":"+hdrs.getRequestHeader(header).get(0));
       }
       return Response.status(200).entity("successfully queried header info").build();
   }

   @GET
   @Path("/userhp")
   @Produces(MediaType.APPLICATION_XML)
   public Response getUserHParams(@HeaderParam("User-Agent") String ua, @HeaderParam("Accept") String acpt, @HeaderParam("XYZ") String abc){
	   
	   System.out.println("User Agent is:"+ua+" accept type:"+acpt+"  ab:"+abc);
       return Response.status(200).entity("successfully got header params").build();
   }
   
   @GET
   @Path("/mparam")
   @Produces(MediaType.APPLICATION_XML)
   public Response getMatrixParams(@MatrixParam("ab") String aval, @MatrixParam("ef") String cval){
	   
	   System.out.println("Matrix Params is:"+aval+"  "+cval);
       return Response.status(200).entity("successfully got Matrix params").build();
   }   
   
   //http://localhost:8084/RESTHeadersEg/rest/EgService/ppparam/
   @POST
   @Path("/ppparam")
   @Consumes(MediaType.APPLICATION_JSON)
   public Response getPostParams(SongTrack st){
	   
	   System.out.println("Post Params is:"+st);
       return Response.status(200).entity("successfully got Post params"+st).build();
   }     

   @GET
   @Path("/qparam")
   @Produces(MediaType.TEXT_PLAIN)
   public Response getPathParams1(@QueryParam("x") String aval, @QueryParam("y") String bval){
	   System.out.println("Query Params is:"+aval+" "+bval);
       return Response.status(200).entity("successfully got Query params").build();	   
   }

	   
   @GET
   @Path("/pparam/{ab}/{xy}")
   @Produces(MediaType.APPLICATION_XML)
   public Response getPathParams(@PathParam("ab") String aval, @PathParam("xy") String bval){
	   
	   System.out.println("Path Params are:"+aval+" and "+bval);
       return Response.status(200).entity("successfully got Path params").build();
   } 
}