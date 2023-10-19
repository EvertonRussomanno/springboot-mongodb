package br.com.evertonmartins.springbootmongodb.services;

import br.com.evertonmartins.springbootmongodb.domain.Post;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface PostService {

    Post findById(String id);

    List<Post> findByTitle(String text);

    List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
