package com.quizserver.service.user;

import com.quizserver.entities.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User createUser(User user);
    User createUserGuest(User user);
    public Boolean hasUserWithEmail(String email);
    User login(User user);
}
