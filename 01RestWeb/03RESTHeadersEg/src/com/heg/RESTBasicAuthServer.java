package com.heg;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sun.misc.BASE64Decoder;
 
@Path("/AService")
public class RESTBasicAuthServer {
 
    @GET
    @Path("/auth")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUserById(@HeaderParam("Authorization") String authString){
         
    	System.out.println("Server Auth:"+authString);
        if(!isUserAuthenticated(authString)){
            return "User not authenticated";
        }

        return "test";
    }
     
    private boolean isUserAuthenticated(String authString){
         
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        decodedAuth = new String(bytes);
        System.out.println(decodedAuth); //usr:pwd
         
        // your validation code goes here....
         
        return true;
    }
}
