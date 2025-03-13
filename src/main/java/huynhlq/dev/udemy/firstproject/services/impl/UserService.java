package huynhlq.dev.udemy.firstproject.services.impl;

import huynhlq.dev.udemy.firstproject.entities.User;
import huynhlq.dev.udemy.firstproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(String username, String pass) {
        String hashedPassword = passwordEncoder.encode(pass);
        User user = new User(username, hashedPassword);
        return userRepository.save(user);
    }
}
