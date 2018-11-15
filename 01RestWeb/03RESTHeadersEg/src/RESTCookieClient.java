

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RESTCookieClient  {

   private Client client;//RestfulExample1/rest/

   private void init(){
      this.client = ClientBuilder.newClient();
   }

   public static void main(String[] args){
	   RESTCookieClient tester = new RESTCookieClient();
      //initialize the tester
      tester.init();

      //tester.testGetCookie();
      tester.testPutCookie();
   }
   
   public void testGetCookie()
   {
	   Response rsp  = client
       .target("http://localhost:8080/RESTHeadersEg/rest/CService/users")
       .request(MediaType.APPLICATION_XML).get();

	   //rsp.getHeaders();
	   
    System.out.println("Test case name: testCookie"+rsp.getStatus()+rsp.getCookies() );
   }
   
   public void testPutCookie()
   {
	   Response rsp  = client
       .target("http://localhost:8080/RESTHeadersEg/rest/CService/userhp")
       .request(MediaType.APPLICATION_XML).cookie("cname", "testval").get();

    System.out.println("Test case name: testHQuery"+rsp.getStatus() );
   }
}