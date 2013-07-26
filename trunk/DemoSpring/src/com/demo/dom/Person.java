package com.demo.dom;

import javax.persistence.Entity;
 


@Entity
public class Person extends BaseEntity {
	
	private String lastName;
	private String firstName;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String name) {
		this.lastName = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + lastName + ", firstname=" + firstName + "]";
	}

}
