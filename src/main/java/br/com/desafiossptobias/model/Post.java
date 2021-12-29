package br.com.desafiossptobias.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"idPost"})
public class Post {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)


	@Column(name = "author")	
	private String author;
	
	private String text;	
	
	@Column(name = "upvotes")
	private Integer upvotes;
	
	@Column(name = "dtpersist")
	private LocalDateTime dtPersist;
	
	@PrePersist
	private void prePersist() {
		this.dtPersist = LocalDateTime.now();
	}
	
	public void addUpvote() {
		if (this.upvotes == null) {
			this.upvotes = 0;
		}
		++this.upvotes;
	}
	private Long idPost;	
	
	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(Integer upvotes) {
		this.upvotes = upvotes;
	}

	public LocalDateTime getDtPersist() {
		return dtPersist;
	}

	public void setDtPersist(LocalDateTime dtPersist) {
		this.dtPersist = dtPersist;
	}
	
	}

