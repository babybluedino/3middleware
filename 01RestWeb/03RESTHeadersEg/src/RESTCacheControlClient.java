

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RESTCacheControlClient  {

   private Client client;//RestfulExample1/rest/
   private String REST_SERVICE_URL = "http://localhost:8080/RestfulExample1/rest/EgService/users";
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String PASS = "pass";
   private static final String FAIL = "fail";

   private void init(){
      this.client = ClientBuilder.newClient();
   }

   public static void main(String[] args){
	   RESTCacheControlClient tester = new RESTCacheControlClient();
      //initialize the tester
      tester.init();

      tester.testCC();
   }
   
   public void testCC()
   {
	   Response rsp  = client
       .target("http://localhost:8080/RESTHeadersEg/rest/CCService/users")
       .request(MediaType.TEXT_PLAIN).get();

    System.out.println("Test case name: testHeaders"+rsp.getStatus() );    
   }
}
