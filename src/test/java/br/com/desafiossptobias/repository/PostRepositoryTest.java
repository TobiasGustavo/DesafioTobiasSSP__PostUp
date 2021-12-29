package br.com.desafiossptobias.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.desafiossptobias.model.Post;




@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

	@Autowired
	private PostRepository repository;
	
	@Test
	public void insertShouldPersistData() {
		Post post = new Post();
		post.setText("Lorem ipsum");
		post.setAuthor("Luiz");
		post = this.repository.save(post);
		
		assertThat(post.getIdPost()).isNotNull();
		assertThat(post.getText()).isEqualTo("Lorem ipsum and Lorem ipsum");
		assertThat(post.getAuthor()).isEqualTo("Tobias Gustavo");
		assertThat(post.getDtPersist()).isNotNull();
	}
	
	@Test
	public void deleteShouldRemoveData() {
		Post post = new Post();
		post.setText("Lorem ipsum and Lorem ipsum");
		post.setAuthor("Tobias Gustavo");
		post = this.repository.save(post);
		
		this.repository.delete(post);
		
		assertThat(this.repository.findById(post.getIdPost()).orElse(null)).isNull();
	}
	
	@Test
	public void updateShouldPersistData() {
		Post post = new Post();
		post.setText("Lorem ipsum");
		post.setAuthor("Tobias");
		post = this.repository.save(post);
		
		post.setText("Ipsum lorem");
		post.setAuthor("Tobias Gustavo");
		
		assertThat(post.getText()).isEqualTo("Ipsum lorem");
		assertThat(post.getAuthor()).isEqualTo("Tobias Gustavo");
	}
	
	@Test
	public void findAllShouldReturnList() {
		Post post = new Post();
		post.setText("Lorem ipsum");
		post.setAuthor("Tobias");
		this.repository.save(post);
		
		Post post2 = new Post();
		post2.setText("Ipsum lorem");
		post2.setAuthor("Tobias Gustavo");
		this.repository.save(post2);
		
		assertThat(this.repository.findAll()).isNotEmpty();
		assertEquals(2, this.repository.findAll().size());
	}
	
	@Test
	public void findByIdShouldReturnPost() {
		Post post = new Post();
		post.setText("Lorem ipsum");
		post.setAuthor("Tobias");
		post = this.repository.save(post);
		
		assertThat(this.repository.findById(post.getIdPost()).orElse(null)).isNotNull();
	}
}



