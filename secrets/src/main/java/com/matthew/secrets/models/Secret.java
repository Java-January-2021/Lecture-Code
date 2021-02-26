package com.matthew.secrets.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="secrets")
public class Secret {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String content;
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date createdAt;
	
	// Linking Users Secret Submission
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User creator;
	
	// Many To Many Table for Likes
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="likes",
			joinColumns = @JoinColumn(name="secret_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	private List<User> likers;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}



	public Secret() {
	
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<User> getLikers() {
		return likers;
	}

	public void setLikers(List<User> likers) {
		this.likers = likers;
	}
	
	
}
