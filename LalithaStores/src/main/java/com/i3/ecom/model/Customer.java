package com.i3.ecom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Customer")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name="customerId")
	public long customerId;
	
	@Column(name="password")
	public String password;
	
	@Column(name="firstName")
	public String firstName;
	
	@Column(name="lastName")
	public String lastName;
	
	@Column(name="contact")
	public String contact;
	
	@Column(name="emailId")
	public String emailId;
	
	@Column(name="emailValidation")
	public boolean emailValidation;
	
	@Column(name="contactValidation")
	public boolean contactValidation;
	
	@Column(name="gender")
	public String gender;
	
	@Column(name="creationDate")
	public Date creationDate;
	
	@Column(name="modificationDate")
	public Date modificationDate;
	
	@Column(name="birthDate")
	public Date birthDate;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean isEmailValidation() {
		return emailValidation;
	}

	public void setEmailValidation(boolean emailValidation) {
		this.emailValidation = emailValidation;
	}

	public boolean isContactValidation() {
		return contactValidation;
	}

	public void setContactValidation(boolean contactValidation) {
		this.contactValidation = contactValidation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
