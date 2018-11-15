
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.heg.SongTrack;

public class RESTJSONClient  {

   private Client client;//RestfulExample1/rest/
   private String REST_SERVICE_URL = "http://localhost:8080/RestfulExample1/rest/EgService/users";
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String PASS = "pass";
   private static final String FAIL = "fail";

   private void init(){
      this.client = ClientBuilder.newClient().register(GsonMessageBodyHandler.class);//register JSON provider with the client
   }

   public static void main(String[] args){
	   RESTJSONClient tester = new RESTJSONClient();
      //initialize the tester
      tester.init();

      tester.testJSONP();
      tester.testJSONClient();
      //tester.testHQuery();
      //tester.testMatrixParam();
   }
   
   public void testJSONClient()
   {
	   
	   SongTrack rsp  = client
       .target("http://localhost:8080/RESTHeadersEg/rest/JSServer/sng")
       .request(MediaType.APPLICATION_JSON)
       .get(SongTrack.class);

	   //SongTrack st = rsp.readEntity(SongTrack.class);
    System.out.println("Test case name: testHeaders"+rsp);
   }
   
   

   public void testJSONP()
   {
	  /* Response rsp  = client
       .target("http://localhost:8080/RESTHeadersEg/rest/EgService/userhp")
       .request(MediaType.APPLICATION_XML).post(SongTrack.class);
       */
		SongTrack track = new SongTrack();
				track.setTitle("CCC TITLE");
				track.setSinger("CCC SINGER");
				track.setDetails("CCC DETAILS");
		
	   String rsp = client.target("http://localhost:8080/RESTHeadersEg/rest/JSServer/psng")
	   							.request(MediaType.APPLICATION_JSON) //mime type of request going from client to server
	                           .accept(MediaType.APPLICATION_XML) //mime type of response(from server) expected by client
	                           .post(Entity.json(track), String.class);

    System.out.println("Test case name: testJSONP"+rsp);
   }
   
 /*  public void testMatrixParam()
   {
	   Response rsp  = client
       .target("http://localhost:8080/RESTHeadersEg/rest/EgService/mparam;ab=value1;ef=value2")
       .request(MediaType.APPLICATION_XML).get();

    System.out.println("Test case name: testMatrixParam"+rsp.getStatus() );
   }*/
}
