


import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RESTExceptionClient  {

   private Client client;//RestfulExample1/rest/
   private String REST_SERVICE_URL = "http://localhost:8080/RestfulExample1/rest/EgService/users";
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String PASS = "pass";
   private static final String FAIL = "fail";

   private void init(){
      this.client = ClientBuilder.newClient();
   }

   public static void main(String[] args){
	   RESTExceptionClient tester = new RESTExceptionClient();
      //initialize the tester
	   try{
      tester.init();

      tester.testException();
	   }
	   catch(Exception et)
	   {
		   et.printStackTrace();
	   }

   }
   
   public void testException()
   {
	   Response rsp  = client
       .target("http://localhost:8080/RESTHeadersEg/rest/EService/users")
       .request(MediaType.APPLICATION_XML).get();

	   String excp = rsp.readEntity(String.class);
    System.out.println("Test case name: testHeaders"+rsp.getStatus()+excp);
   }
}
