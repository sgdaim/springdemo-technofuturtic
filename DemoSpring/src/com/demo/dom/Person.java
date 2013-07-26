package com.demo.dom;

import javax.persistence.Entity;
 


@Entity
public class Person extends BaseEntity {
	
	private String lastName;
	private String firstname;
	
	public String getLastName() {
		return lastName;
	}
	public void setName(String name) {
		this.lastName = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + lastName + ", firstname=" + firstname + "]";
	}

}
