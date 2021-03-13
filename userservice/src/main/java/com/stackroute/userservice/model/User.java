package com.stackroute.userservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class User {
	
	//@ApiModelProperty(name="User Id",notes="Id of the user",dataType="string")
	@Id
	@Column(length=50)
	private String userId;
	
	//@ApiModelProperty(name="First Name",notes="First name of the user",dataType="string")
	//@Column
	private String firstName;
	
	//@ApiModelProperty(name="Last Name",notes="Last name of the user",dataType="string")
	//@Column
	private String lastName;
	
	//@ApiModelProperty(name="Password",notes="Password of the user",dataType="string")
	//@Column
	private String password;
	
	@CreationTimestamp
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;

	public User(String userId, String firstName, String lastName,
			String password, Date createdDate) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.createdDate = createdDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User() {
	}
	

}
