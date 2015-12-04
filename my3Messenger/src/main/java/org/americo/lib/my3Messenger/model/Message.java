package org.americo.lib.my3Messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

//DAO CLASS
@XmlRootElement
public class Message {

	//ATTRIBUTE
	private long id;
	private String message;
	private Date created;
	private String author;
	
	//CONSTRUCTOR
	public Message() {
		//...NO ARGS Constructor: XML or JSON conversion
	}
	
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	
	//GETTERS AND SETTERS
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}