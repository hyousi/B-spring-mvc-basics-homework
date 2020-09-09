package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private Set<User> users;

    public UserRepository() {
        users = new HashSet<>();
    }

    public void add(User user) {
        users.add(user);
    }

    public int size() {
        return users.size();
    }

    public User findUserByUserName(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
    }
}
