package huynhlq.dev.udemy.firstproject.apiAction;

import huynhlq.dev.udemy.firstproject.exception.CustomErrorException;
import huynhlq.dev.udemy.firstproject.model.dto.UserDTO;
import huynhlq.dev.udemy.firstproject.model.entity.User;
import huynhlq.dev.udemy.firstproject.model.request.LoginRequest;
import huynhlq.dev.udemy.firstproject.model.response.LoginResponse;
import huynhlq.dev.udemy.firstproject.model.response.LoginResponseData;
import huynhlq.dev.udemy.firstproject.util.JwtUtil;
import huynhlq.dev.udemy.firstproject.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthAction {

    private final UserServiceImpl userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthAction(UserServiceImpl userService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            String token = jwtUtil.generateAccessToken(request.getUsername());
            UserDTO userDTO = userService.findByUsername(request.getUsername());
            LoginResponse response = new LoginResponse("0000", new LoginResponseData(token,userDTO));

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            throw new CustomErrorException("invalid username or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User request) {
        UserDTO userDTO = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

}
