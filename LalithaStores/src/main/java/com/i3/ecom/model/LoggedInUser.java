package com.i3.ecom.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoggedInUser extends User {
	
	 	private Long currentUserId;
	 	private String currentUserRole;
		private String firstName;
		private String lastName;
		private String emailId;
		    
	    public Long getCurrentUserId() {
			return currentUserId;
		}

		public void setCurrentUserId(Long currentUserId) {
			this.currentUserId = currentUserId;
		}

		public String getCurrentUserRole() {
			return currentUserRole;
		}

		public void setCurrentUserRole(String currentUserRole) {
			this.currentUserRole = currentUserRole;
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

	  

	public LoggedInUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoggedInUser [currentUserId=");
		builder.append(currentUserId);
		builder.append(", currentCompanyId=");
		builder.append(emailId);
		builder.append(", currentUserRole=");
		builder.append(currentUserRole);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
