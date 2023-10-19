package br.com.evertonmartins.springbootmongodb.services.impl;

import br.com.evertonmartins.springbootmongodb.domain.User;
import br.com.evertonmartins.springbootmongodb.dto.UserDTO;
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
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    @Override
    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    @Override
    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @Override
    public User update(User obj) {
        User newObj = userRepository.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Not found!"));
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
