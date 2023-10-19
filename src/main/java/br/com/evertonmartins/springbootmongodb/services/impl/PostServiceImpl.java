package br.com.evertonmartins.springbootmongodb.services.impl;

import br.com.evertonmartins.springbootmongodb.domain.Post;
import br.com.evertonmartins.springbootmongodb.repository.PostRepository;
import br.com.evertonmartins.springbootmongodb.services.PostService;
import br.com.evertonmartins.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post not found!"));
    }
}
