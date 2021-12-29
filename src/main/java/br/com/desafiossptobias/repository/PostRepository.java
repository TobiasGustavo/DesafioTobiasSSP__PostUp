package br.com.desafiossptobias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiossptobias.model.Post;

@Repository
public interface PostRepository extends JpaRepository <Post,Long> {
 	
}
