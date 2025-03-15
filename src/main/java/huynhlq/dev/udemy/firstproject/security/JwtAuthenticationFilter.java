package huynhlq.dev.udemy.firstproject.security;

import huynhlq.dev.udemy.firstproject.service.impl.CustomUserDetailsService;
import huynhlq.dev.udemy.firstproject.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(
            JwtUtil jwtUtil,
            CustomUserDetailsService userDetailsService,
            AuthenticationManager authenticationManager
    ) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. get the authentication header. Tokens are supposed to be passed in the authentication header
        String header = request.getHeader("Authorization");

        // 2. validate the header and check the prefix
        if(header == null || !header.startsWith(jwtUtil.getPrefix())) {
            filterChain.doFilter(request, response);  		// If not valid, go to the next filter.
            return;
        }

        try {
            // 3. Get the token
            String token = header.replace(jwtUtil.getPrefix(), "").replace(" ", "");
            // 4. Validate the token
            String username = jwtUtil.extractUsername(token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                if (jwtUtil.validateAccessToken(token, userDetails.getUsername())) {

                    // 5. Create auth object
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                            username, null, userDetails.getAuthorities());
                    // 6. Authenticate the user
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        } catch (Exception e) {
            // In case of failure. Make sure it's clear; so guarantee user won't be authenticated
            SecurityContextHolder.clearContext();
        }

        // Go to the next filter in the filter chain
        filterChain.doFilter(request, response);
    }
}
