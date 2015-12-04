package org.americo.lib.my3Messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.americo.lib.my3Messenger.database.DatabaseClass;
import org.americo.lib.my3Messenger.model.Message;

public class MessageService {
	
	//ATTRIBUTES
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	//CONSTRUCOR
	public MessageService() {
		//DATA FOR MAP
		messages.put(1L, new Message(3L, "my THIRD JAX-RS", "AmericoTomas"));
		messages.put(2L, new Message(4L, "my FORTH JAX-RS", "AnaBatalha"));
	}
	
	/** Service: prints all messages to a list */
 	public List<Message> getAllMessages_array() {
		//LIST
		List<Message> list = new ArrayList<Message>();
		
		//DATA
		Message m1 = new Message(1L, "my First JAX-RS", "Americo");
		list.add(m1);
		Message m2 = new Message(2L, "my Second JAX-RS", "Ana");
		list.add(m2);
		
		//RETURN
		return list;
	}
	
	/** Service: prints all messages to a list MAP */
	public List<Message> getAllMessages_map() {
		//ARRAYLIST IN MAP
		return new ArrayList<Message>(messages.values());
	}
	
	/** @GET message*/
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	/** @ADD message*/
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	/** @UPDATE message */
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	/** @REMOVE message */
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}