package me.learning.service.impl;

import me.learning.domain.model.User;
import me.learning.domain.repository.UserRepository;
import me.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User userToCreate) {

        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())){
            throw new IllegalArgumentException("This ID already exists.");
        }

        if(userToCreate.getUsername() != null && userRepository.existsByUsername(userToCreate.getUsername())){
            throw new IllegalArgumentException("This Username already exists.");
        }

        return userRepository.save(userToCreate);
    }
}
