package com.heg;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/JSServer")
public class RESTJSONServer {


	@GET
	@Path("/sng")
	@Produces(MediaType.APPLICATION_JSON)
	public SongTrack getTrackInJSON() {

		SongTrack track = new SongTrack();
		track.setTitle("ABC TITLE");
		track.setSinger("XYZ SINGER");
		track.setDetails("DUMMY DETAILS");

		System.out.println("getTrackInJSON()....");
		return track;

	}

	@PUT
	@Path("/psng")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_XML)
	public String createTrackInJSON(SongTrack track) {

		String result = "Track saved : " + track;
		System.out.println("createTrackInJSON()...."+result);
		return "<result>SUCCESS</result>";

	}

}
