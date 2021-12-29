package br.com.desafiossptobias.model.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostForm {
	
	@NotBlank
	@Length(max = 300)
	private String text;
	
	@NotBlank 
	@Length(max = 30)
	private String author;

	public PostForm(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}
}
