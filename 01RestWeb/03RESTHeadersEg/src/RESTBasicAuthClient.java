

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import sun.misc.BASE64Encoder;

public class RESTBasicAuthClient  {

   private Client client;//RestfulExample1/rest/
   private String REST_SERVICE_URL = "http://localhost:8080/RestfulExample1/rest/EgService/users";
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String PASS = "pass";
   private static final String FAIL = "fail";

   private void init(){
	   /*HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
	    .nonPreemptive()
	    .credentials("hello", "secretpd")
	    .build();

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(feature) ;
	      this.client = ClientBuilder.newClient(clientConfig);*/
	   this.client = ClientBuilder.newClient();


   }

   public static void main(String[] args){
	   RESTBasicAuthClient tester = new RESTBasicAuthClient();
      //initialize the tester
      tester.init();

      tester.testBAuth();
   }
   
   public void testBAuth()
   {
	      String name = "tstuser";
	        String password = "Simplepwd";
	        String authString = name + ":" + password;
	        String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
	        System.out.println("Base64 encoded auth string: " + authStringEnc);
	        
	   String str = client
       .target("http://localhost:8080/RESTHeadersEg/rest/AService/auth")
       .request(MediaType.TEXT_PLAIN).header("Authorization", "Basic " + authStringEnc)
       .get(String.class);

    System.out.println("Test case name: testBAuth"+str );
   }
}

/*
 HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
    .nonPreemptive()
    .credentials("user", "password")
    .build();

ClientConfig clientConfig = new ClientConfig();
clientConfig.register(feature) ;

Client client = ClientBuilder.newClient(clientConfig);
*/