package com.i3.ecom.model;

import java.util.Date;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.json.JSONObject;

import static com.i3.ecom.utils.UserConstants.EMAIL_ID;
import static com.i3.ecom.utils.UserConstants.PASSWORD;
import static com.i3.ecom.utils.UserConstants.CONTACT;
import static com.i3.ecom.utils.UserConstants.FIRST_NAME;
import static com.i3.ecom.utils.UserConstants.LAST_NAME;
import static com.i3.ecom.utils.UserConstants.LOCATION;
import static com.i3.ecom.utils.UserConstants.MODIFICATION_DATE;
import static com.i3.ecom.utils.UserConstants.STATUS;


@Entity(name="users")
public class Users {
	
	@Id
	@GeneratedValue
	@Column(name="userId")
	public Long userId;
	
	@Column(name="status")
	public boolean status;
	
	@Column(name="firstName")
	public String firstName;
	
	@Column(name="lastName")
	public String lastName;
	
	@Column(name="emailId")
	public String emailId;
	
	@Column(name="password")
	public String password;
	
	@Column(name="contact")
	public String contact;
	
	@Column(name="location")
	public String location;
	
	@Column(name="modificationDate")
	public Date modificationDate;
	
	@Column(name="creationDate")
	public Date creationDate;
	
	
	
	public Date getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public boolean getStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
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



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public Date getModificationDate() {
		return modificationDate;
	}



	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}



	public static Users getUser(String userJason){
		
		Users users =new Users();
		JSONObject jsonObject =new JSONObject(userJason);
		Iterator<?> keys = jsonObject.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			switch (key) {
			
			case EMAIL_ID:
				users.setEmailId(jsonObject.getString(key));
				break;
			case PASSWORD:
				users.setPassword(jsonObject.getString(key));
				break;
			case FIRST_NAME:
				users.setFirstName(jsonObject.getString(key));
				break;
			case LAST_NAME:
				users.setLastName(jsonObject.getString(key));
				break;
			case CONTACT:
				users.setContact(jsonObject.getString(key));
				break;
			case LOCATION:
				users.setLocation(jsonObject.getString(key));
				break;
			case STATUS:
				users.setStatus(jsonObject.getBoolean(key));
				break;
			default : 
				break;
			}
			
			
			
		}
		return users;
		
	}
	
	
	
	
}
