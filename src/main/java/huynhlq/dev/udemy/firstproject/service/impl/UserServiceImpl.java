package huynhlq.dev.udemy.firstproject.service.impl;

import huynhlq.dev.udemy.firstproject.exception.CustomErrorException;
import huynhlq.dev.udemy.firstproject.model.dto.UserDTO;
import huynhlq.dev.udemy.firstproject.model.entity.User;
import huynhlq.dev.udemy.firstproject.repository.UserRepository;
import huynhlq.dev.udemy.firstproject.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    /// PROPERTIES
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /// PRIVATE METHOD
    private UserDTO getUserDTO(User user) {
        return new UserDTO(
                user.getUsername(),
                user.getFullName(),
                user.getCreatedAt() == null ? "" : user.getCreatedAt().toString(),
                user.getUpdatedAt() == null ? "" : user.getUpdatedAt().toString()
        );
    }

    ///  PUBLIC METHOD
    public boolean validate(String username, String password) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return false;
        } else {
            return passwordEncoder.matches(password, user.getPassword());
        }
    }

    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if(user != null) {
            return getUserDTO(user);
        }
        return null;
    }

    public UserDTO save(User userRequest) {
        try {
            String hashedPassword = passwordEncoder.encode(userRequest.getPassword());
            userRequest.setPassword(hashedPassword);
            User userCreated = userRepository.save(userRequest);
            return getUserDTO(userCreated);
        } catch (Exception e) {
            throw new CustomErrorException("Username: " + userRequest.getUsername() + " already exists!");
        }
    }
}
