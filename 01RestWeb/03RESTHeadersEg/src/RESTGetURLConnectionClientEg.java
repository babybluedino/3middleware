

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.core.MediaType;
 
public class RESTGetURLConnectionClientEg {
 
    public static void main(String a[]){
         
        String url = "http://localhost:8080/RESTHeadersEg/rest/EgService/pparam/56/65";
        HttpURLConnection urlConn = null;
        BufferedReader reader = null;
        try {
            URL urlObj = new URL(url);
            urlConn = (HttpURLConnection) urlObj.openConnection();
            urlConn.setRequestMethod("GET");
            urlConn.setConnectTimeout(5000);
            urlConn.setReadTimeout(5000);
            urlConn.setRequestProperty("Accept", MediaType.APPLICATION_XML);
            if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.err.println("Unable to connect to the URL...");
                return;
            }
            System.out.println("Connected to the server...");
            InputStream is = urlConn.getInputStream();
            reader = new BufferedReader(new InputStreamReader((is)));
            System.out.println("Reading data from server...");
            String tmpStr = null;
            while((tmpStr = reader.readLine()) != null){
                System.out.println(tmpStr);
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if(reader != null) reader.close();
                if(urlConn != null) urlConn.disconnect();
            } catch(Exception ex){
                 
            }
        }
    }
}
