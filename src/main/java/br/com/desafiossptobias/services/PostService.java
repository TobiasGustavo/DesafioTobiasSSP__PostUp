package br.com.desafiossptobias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.desafiossptobias.model.Post;
import br.com.desafiossptobias.model.dto.PostDto;
import br.com.desafiossptobias.model.form.PostForm;
import br.com.desafiossptobias.repository.PostRepository;


@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	

	public PostDto insert(PostForm form) {
		Post post = new Post();
		post.setText(form.getText());
		post.setAuthor(form.getAuthor());
		post = postRepository.save(post);
		return new PostDto(post);
	}
	
	public List<PostDto> findAll(Pageable pageable) {
		pageable = PageRequest.of(pageable.getPageNumber(), 
				pageable.getPageSize(), Sort.by("dtPersist").descending());
		Page<Post> posts = postRepository.findAll(pageable);
		return posts.map((post) -> new PostDto(post)).getContent();
	}
	
	public PostDto addUpvote(Long idPost) {
		Post post = postRepository.findById(idPost).orElseThrow(() -> new EmptyResultDataAccessException(1));		 
		post.addUpvote();
		post = postRepository.save(post);
		return new PostDto(post);
	}
}


