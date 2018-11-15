

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RESTClient  {

   private Client client;//RestfulExample1/rest/
   private String REST_SERVICE_URL = "http://localhost:8080/RestfulExample1/rest/EgService/users";
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String PASS = "pass";
   private static final String FAIL = "fail";

   private void init(){
      this.client = ClientBuilder.newClient();
   }

   public static void main(String[] args){
	   RESTClient tester = new RESTClient();
      //initialize the tester
      tester.init();

      tester.testPathParam();
      //tester.testHeaders();
      //tester.testHQuery();
      tester.testMatrixParam();
   }
   
   public void testHeaders()
   {
	   Response rsp  = client
       .target("http://localhost:8080/RESTHeadersEg/rest/EgService/users")
       .request(MediaType.APPLICATION_XML).get();

    System.out.println("Test case name: testHeaders"+rsp.getStatus() );
   }
   
   public void testHQuery()
   {
	   Response rsp  = client
       .target("http://localhost:8080/RESTHeadersEg/rest/EgService/userhp")
       .request(MediaType.APPLICATION_XML)
       .header("XYZ", "TESTPURPOSE")
       .header("KKK", "THISISNOTREQUIRED")
       .get();

    System.out.println("Test case name: testHQuery"+rsp.getStatus() );
   }
   
   public void testMatrixParam()
   {
	   Response rsp  = client
       .target("http://localhost:8080/RESTHeadersEg/rest/EgService/mparam;ab=value1;ef=value2")
       .request(MediaType.APPLICATION_XML).get();

    System.out.println("Test case name: testMatrixParam"+rsp.getStatus() );
   }
   
   public void testPathParam()
   {
	   Response rsp  = client
       .target("http://localhost:8080/RESTHeadersEg/rest/EgService/pparam/56")
       .request(MediaType.APPLICATION_XML).get();

    System.out.println("Test case name: testPathParam"+rsp.getStatus() );
   }
}