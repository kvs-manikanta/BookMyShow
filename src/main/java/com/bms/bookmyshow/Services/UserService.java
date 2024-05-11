package com.bms.bookmyshow.Services;

import com.bms.bookmyshow.Exceptions.UserNotFoundException;
import com.bms.bookmyshow.Models.User;
import com.bms.bookmyshow.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public User signup(String name, String email, String password) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);
    }

    public User login(String email, String password) throws UserNotFoundException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Optional<User> optionalUser=userRepository.findByEmail(email);

        if(optionalUser.isEmpty())
        {
            throw new UserNotFoundException("User with email" + email + "not found");
        }

        User user = optionalUser.get();

        if(bCryptPasswordEncoder.matches(password, user.getPassword()))
        {
            return user;
        }
        throw new RuntimeException("Password mismatch");

    }

}
