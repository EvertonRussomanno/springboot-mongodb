package br.com.evertonmartins.springbootmongodb.services;

import br.com.evertonmartins.springbootmongodb.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    Post findById(String id);

    List<Post> findByTitle(String text);

}
