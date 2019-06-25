package com.sample.login.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1008108121100229115L;

	private String name, surname, username, password, email, phone, bio;

	private Long DOB;

	private int rating;

	public UserDTO(String name, String surname, Long DOB, String email, String bio, String phone, String username,
			String password) {
		this.name = name;
		this.surname = surname;
		this.DOB = DOB;
		this.email = email;
		this.bio = bio;
		this.phone = phone;
		this.username = username;
		if (password != null) {
			this.password = password;
		}
	}

	public UserDTO() {
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Long getDOB() {
		return DOB;
	}

	public void setDOB(Long dOB) {
		DOB = dOB;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", surname=" + surname + ", username=" + username + ", email=" + email
				+ ", phone=" + phone + ", bio=" + bio + ", DOB=" + DOB + ", rating=" + rating + "]";
	}
}
