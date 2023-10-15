package br.com.evertonmartins.springbootmongodb.services;

import br.com.evertonmartins.springbootmongodb.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAll();
    User findById(String id);
}
