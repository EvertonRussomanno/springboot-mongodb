package br.com.evertonmartins.springbootmongodb.services;

import br.com.evertonmartins.springbootmongodb.domain.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    Post findById(String id);
}
