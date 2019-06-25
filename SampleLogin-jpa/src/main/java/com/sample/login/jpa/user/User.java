package com.sample.login.jpa.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "user_id")
	private Long user_id;

	@Column(name = "name", nullable = false)
	@Size(max = 24)
	private String name;

	@Column(name = "surname")
	@Size(max = 24)
	private String surname;

	@Column(name = "DOB")
	private Long DOB;

	@Column(name = "username", nullable = false, unique = true)
	@Size(min = 4, max = 16)
	private String username;

	@Column(name = "password", nullable = false)
	@Size(min = 6, max = 16)
	private String password;

	@Column(name = "email", nullable = false)
	@Size(min=5, max = 32)
	private String email;

	@Column(name = "phone")
	@Size(max = 16)
	private String phone;

	@Column(name = "created_at", nullable = false)
	private Long created_at;

	@Column(name = "updated_at", nullable = false)
	private Long updated_at;

	@Column(name = "logged_at", nullable = false)
	private Long logged_at;

	public User() {
		
	}

	public User(String name, String surname, Long DOB, String email, String bio, String phone, String username, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.DOB = DOB;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;

		this.created_at = System.currentTimeMillis();
		this.updated_at = System.currentTimeMillis();
		this.logged_at = System.currentTimeMillis();
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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

	public Long getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Long created_at) {
		this.created_at = created_at;
	}

	public Long getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Long updated_at) {
		this.updated_at = updated_at;
	}

	public Long getLogged_at() {
		return logged_at;
	}

	public void setLogged_at(Long logged_at) {
		this.logged_at = logged_at;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", surname=" + surname + ", DOB=" + DOB + ", username="
				+ username + ", password=" + password + ", email=" + email + ", phone=" + phone + ", created_at="
				+ created_at + ", updated_at=" + updated_at + ", logged_at=" + logged_at + "]";
	}	
}
