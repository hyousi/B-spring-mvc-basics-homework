package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistsException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user) {
        int prevSize = userRepository.size();
        userRepository.add(user);
        int currSize = userRepository.size();
        if (currSize == prevSize) {
            throw new UserExistsException("用户已存在");
        }
    }
}
