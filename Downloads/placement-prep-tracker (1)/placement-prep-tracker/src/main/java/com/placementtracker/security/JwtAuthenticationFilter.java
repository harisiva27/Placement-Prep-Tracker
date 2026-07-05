package com.placementtracker.security;

import com.placementtracker.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;

    public JwtAuthenticationFilter(JwtUtil jwtUtil, CustomUserDetailsService customUserDetailsService) {
        this.jwtUtil = jwtUtil;
        this.customUserDetailsService = customUserDetailsService;
    }

    /**
     * Filter method that executes once per request
     * Validates JWT token and sets authentication in SecurityContext
     * 
     * @param request the HTTP request
     * @param response the HTTP response
     * @param filterChain the filter chain
     * @throws ServletException if a servlet error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain) throws ServletException, IOException {
        
        // Step 1: Read the Authorization header from the request
        String authorizationHeader = request.getHeader("Authorization");
        
        String username = null;
        String token = null;

        // Step 2: Check if the header exists and starts with "Bearer "
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // Step 3: Extract the JWT token (remove "Bearer " prefix)
            token = authorizationHeader.substring(7);
            
            try {
                // Step 4: Use JwtUtil to extract the username from the token
                username = jwtUtil.extractUsername(token);
            } catch (Exception e) {
                // Token is invalid or malformed
                logger.error("Error extracting username from token: " + e.getMessage());
            }
        }

        // Step 5: If username is extracted and no authentication is set in SecurityContext
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                // Step 6: Load the user details using CustomUserDetailsService
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                
                // Step 7: Validate the token using JwtUtil
                if (jwtUtil.validateToken(token)) {
                    // Step 8: Create UsernamePasswordAuthenticationToken with user details and authorities
                    UsernamePasswordAuthenticationToken authenticationToken = 
                            new UsernamePasswordAuthenticationToken(
                                    userDetails, 
                                    null, 
                                    userDetails.getAuthorities()
                            );
                    
                    // Set additional details (like remote address, session ID)
                    authenticationToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    
                    // Step 9: Store the authentication in SecurityContextHolder
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            } catch (Exception e) {
                logger.error("Error during authentication: " + e.getMessage());
            }
        }

        // Step 10: Continue the filter chain to the next filter
        filterChain.doFilter(request, response);
    }
}
