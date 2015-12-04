package org.americo.lib.my3Messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.americo.lib.my3Messenger.model.Message;
import org.americo.lib.my3Messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	//ATTRIBUTES
	MessageService messageService = new MessageService();
	
	//GET########################################################
	@GET
	@Path("/start")
	@Produces(MediaType.TEXT_PLAIN)
	public String get1Start() {
		String toReturn = "Hello World of JAX-RS (navegate throw thw API)\n";
		toReturn += "//#############################################\n";
		toReturn += "\n";
		toReturn += "//START\n";
		toReturn += "localhost:8085/my3Messenger/americo/messages/start\n";
		toReturn += "localhost:8085/my3Messenger/americo/messages/test\n";
		toReturn += "localhost:8085/my3Messenger/americo/messages/test/1\n";
		toReturn += "\n";
		toReturn += "//GET ALL ARRAYLIST\n";
		toReturn += "localhost:8085/my3Messenger/americo/messages/array\n";
		toReturn +=	"localhost:8085/my3Messenger/americo/messages/array/json\n";	
		toReturn += "//GET ALL ARRAYLIST\n";
		toReturn += "localhost:8085/my3Messenger/americo/messages/array\n";
		toReturn += "localhost:8085/my3Messenger/americo/messages/array/json\n";
		toReturn += "\n";
		toReturn += "//GET ALL MAPLIST\n";
		toReturn += "localhost:8085/my3Messenger/americo/messages/\n";				
		toReturn += "localhost:8085/my3Messenger/americo/messages/map/json\n";
		toReturn += "\n";
		toReturn += "//GET MESSAGE\n";
		toReturn += "localhost:8085/my3Messenger/americo/messages/1\n";
		toReturn += "localhost:8085/my3Messenger/americo/messages/2\n";
		
		//RETURN STRING
		return toReturn;
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_XML)
	public String get1Test() {
		String toReturn = "<!DOCTYPE html>";
		toReturn += "<html>";
		toReturn += "<head>";
		toReturn += "<title><p>myCinema</p></title>";
		toReturn += "</head>";
		toReturn += "<body>";
		toReturn += "<h1>MY TRAILER LIB</h1>";
		toReturn += "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/sGbxmsDFVnE\" frameborder=\"0\" allowfullscreen></iframe>";
		toReturn += "</body>";
		toReturn += "</html>";
		return toReturn;
	}
	
	@GET
	@Path("/test/{messageId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String get2Test(@PathParam("messageId") String messageId) {
		return messageId + " = testing variable element... SUCCESS!!";
	}
	
	@GET
	@Path("/array")
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getAllMessage_array() {
		return messageService.getAllMessages_array();
	}
	
	@GET
	@Path("/map")
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getAllMessages_map() {
		return messageService.getAllMessages_map();
	}
	
	@GET
	@Path("/array/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessage_array_json() {
		return messageService.getAllMessages_array();
	}
	
	@GET
	@Path("/map/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages_map_json() {
		return messageService.getAllMessages_map();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId) {
		return messageService.getMessage(messageId);
	}

	//POST########################################################
	@POST
	@Path("/test/post")
	@Produces(MediaType.APPLICATION_XML)
	public String addMessage() {	
		return "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/sGbxmsDFVnE\" frameborder=\"0\" allowfullscreen></iframe>";
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}


	


}