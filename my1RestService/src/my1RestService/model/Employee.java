package my1RestService.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Employee {
	
	//ATTRIBUTES
	private Integer id;
	private String name;
	
	//CONSTRUCTOR
	public Employee(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Employee() {
		super();
		
	}
}
