package huynhlq.dev.udemy.firstproject.Auth.Responses;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
//@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Lấy thông tin user
        User user = (User) authentication.getPrincipal();
//        String token = jwtService.generateToken(user); // Tạo JWT

        // Trả về JSON
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("status", "success");
        responseData.put("token", "token");
        responseData.put("user", user.getUsername());

        response.getWriter().write(new ObjectMapper().writeValueAsString(responseData));
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
