package com.reg;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class RESTfulJerseyClient {

	private static final String webServiceURI = "http://localhost:8084/RESTFirstExample";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);

		// response
		System.out.println(webTarget.path("rest").path("helloworlds").request()
				.accept(MediaType.TEXT_PLAIN) //client expects plain text
				.get(Response.class).toString()); //client sends thru HTTP GET Method

		// text
		/*System.out.println(webTarget.path("rest").path("helloworlds").request()
				.accept(MediaType.TEXT_PLAIN) //client expects plain text
				.get(String.class)); //client sends thru HTTP GET Method
				

		// xml
		System.out.println(webTarget.path("rest").path("helloworlds").request()
				.accept(MediaType.TEXT_XML) //client expects XML text
				.get(String.class)); //client sends thru HTTP GET Method

		// html
		System.out.println(webTarget.path("rest").path("helloworlds").request()
				.accept(MediaType.TEXT_HTML)  //client expects html text
				.get(String.class)); //client sends thru HTTP GET Method
				*/
	}
}

