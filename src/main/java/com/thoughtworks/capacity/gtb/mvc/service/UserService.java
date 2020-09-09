package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistsException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import javax.naming.AuthenticationException;
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

    public User login(String username, String password) throws AuthenticationException {
        User user = userRepository.findUserByUserName(username);
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("用户名或密码错误");
        }
        return user;
    }
}
