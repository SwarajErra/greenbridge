package com.greenbridge.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "farmers")
public class Farmer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private String password;
	private String mobileNumber;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "farmer")
	private List<Crop> crops;
	
	
   public Farmer() {
	   
   }


public Farmer(String firstName, String lastName, Integer age, String gender, String password, String mobileNumber) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.gender = gender;
	this.password = password;
	this.mobileNumber = mobileNumber;
}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public Integer getAge() {
	return age;
}


public void setAge(Integer age) {
	this.age = age;
}


public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getMobileNumber() {
	return mobileNumber;
}


public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}


   
   

}
