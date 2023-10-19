package br.com.evertonmartins.springbootmongodb.services.impl;

import br.com.evertonmartins.springbootmongodb.domain.Post;
import br.com.evertonmartins.springbootmongodb.repository.PostRepository;
import br.com.evertonmartins.springbootmongodb.services.PostService;
import br.com.evertonmartins.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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

    @Override
    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
//        return postRepository.findByTitleContainingIgnoreCase(text);
    }

    @Override
    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
