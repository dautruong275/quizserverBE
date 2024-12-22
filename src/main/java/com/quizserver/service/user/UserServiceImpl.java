package com.quizserver.service.user;

import com.quizserver.entities.User;
import com.quizserver.enums.UserRole;
import com.quizserver.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void createAdminUser(){
        User optionalUser = userRepository.findByRole(UserRole.ADMIN);
        if (optionalUser == null){
            User user = new User();
            user.setName("admin");
            user.setEmail("");
            user.setRole(UserRole.ADMIN);
            user.setPassWord("admin");
            userRepository.save(user);
        }
    }

    @Override
    public Boolean hasUserWithEmail(String email){
        return userRepository.findFirstByEmail(email) != null;
    }
    @Override
    public User createUser(User user){
        user.setRole(UserRole.USER);
        return userRepository.save(user);
    }
    @Override
    public User createUserGuest(User user){
        user.setRole(UserRole.GUEST);
        return userRepository.save(user);
    }

    public User login(User user){
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent() && user.getPassWord().equals(optionalUser.get().getPassWord())){
            return optionalUser.get();
        }
        return  null;
    }

}
