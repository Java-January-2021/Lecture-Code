package com.matthew.secrets.models;

import java.beans.Transient;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max=15)
	private String firstName;
	@NotBlank
	@Size(max=30)
	private String lastName;
	@Email
	@NotBlank
	private String email;
	@Size(min=8)
	private String password;
	@Transient
	private String confirmPassword;
	
	
	public List<Secret> getSecrets() {
		return secrets;
	}
	public void setSecrets(List<Secret> secrets) {
		this.secrets = secrets;
	}
	public List<Secret> getLikes() {
		return likes;
	}
	public void setLikes(List<Secret> likes) {
		this.likes = likes;
	}
	// Keeping Track of User's Secrets Submissions
	@OneToMany(mappedBy="creator", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Secret> secrets;
	
	
	// Many To Many Table for Likes!
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="likes",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="secret_id")
			)
	private List<Secret> likes;
	
	public User() {

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
}
