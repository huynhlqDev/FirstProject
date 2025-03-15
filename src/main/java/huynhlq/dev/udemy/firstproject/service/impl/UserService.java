package huynhlq.dev.udemy.firstproject.service.impl;

import huynhlq.dev.udemy.firstproject.model.dto.UserDTO;
import huynhlq.dev.udemy.firstproject.model.entity.User;
import huynhlq.dev.udemy.firstproject.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO getUserDTO(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if(user != null) {
            return new UserDTO(
                    user.getUsername(),
                    user.getFullName(),
                    user.getCreatedAt() == null ? "" : user.getCreatedAt().toString(),
                    user.getUpdatedAt() == null ? "" : user.getUpdatedAt().toString()
            );
        }
        return null;
    }

    public void save(String username, String pass) {
        String hashedPassword = passwordEncoder.encode(pass);
        User user = new User(username, hashedPassword);
        userRepository.save(user);
    }
}
