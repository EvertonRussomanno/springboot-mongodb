package br.com.evertonmartins.springbootmongodb.services.impl;

import br.com.evertonmartins.springbootmongodb.domain.User;
import br.com.evertonmartins.springbootmongodb.repository.UserRepository;
import br.com.evertonmartins.springbootmongodb.services.UserService;
import br.com.evertonmartins.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object no found!"));
    }
}
