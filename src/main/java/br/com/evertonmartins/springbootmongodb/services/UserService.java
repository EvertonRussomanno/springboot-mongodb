package br.com.evertonmartins.springbootmongodb.services;

import br.com.evertonmartins.springbootmongodb.domain.User;
import br.com.evertonmartins.springbootmongodb.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAll();
    User findById(String id);
    User insert(User obj);
    User fromDTO(UserDTO objDto);
    void delete(String id);
}
