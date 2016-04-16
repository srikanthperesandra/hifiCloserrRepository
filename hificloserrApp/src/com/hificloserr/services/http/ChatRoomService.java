/**
 * 
 */
package com.hificloserr.services.http;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hificloserr.services.entity.IChatRoomsFacade;
import com.hificloserr.util.LoggerUtil;

/**
 * @author spl
 *
 */
@Path("/chatrooms")
public class ChatRoomService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getChatRooms(@QueryParam("lat")double lat,
			@QueryParam("lng") double lng,
			@QueryParam("area") int area){
		try{
			return Response.ok().entity(IChatRoomsFacade.eINSTANCE.start(lat, lng, area).toString()).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.serverError().entity(LoggerUtil.toString(e)).build();
		}
	}
	
	
}
