package br.com.desafiossptobias.model.dto;

import java.time.LocalDateTime;

import br.com.desafiossptobias.model.Post;
import lombok.Data;

@Data
public class PostDto {


	private Long idPost;
	private String text;
	private String author;
	private int upvotes;
	private LocalDateTime dtPersist;
	
	public PostDto() {
	}
	
	public PostDto(Long idPost, String text, String author) {
		this.idPost = idPost;
		this.text = text;
		this.author = author;
	}
	
	public PostDto(String text, String author) {
		this.text = text;
		this.author = author;
	}
	
	public PostDto(Post post) {
		this.idPost = post.getIdPost();
		this.text = post.getText();
		this.author = post.getAuthor();		
		this.upvotes = post.getUpvotes() != null ? post.getUpvotes().intValue() : 0;
		this.dtPersist = post.getDtPersist();
	}
	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}

	public LocalDateTime getDtPersist() {
		return dtPersist;
	}

	public void setDtPersist(LocalDateTime dtPersist) {
		this.dtPersist = dtPersist;
	}

	}

