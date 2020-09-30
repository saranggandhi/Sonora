package com.directory.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "person")
public class Person {

	private long id;
	private String name;
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	private String country;
	private String avatar;
	
	public Person(String name, String email, Date dob, String country, String avatar) {
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.country = country;
		this.avatar = avatar;
	}
	
	public Person() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "dob", nullable = false)
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Column(name = "country", nullable = false)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "avatar", nullable = false)
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", dob=" + dob + ", avatar=" + avatar + ", email=" + email + ", country=" + country + "]";
	}
}
