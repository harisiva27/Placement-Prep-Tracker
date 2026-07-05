package com.placementtracker.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Secret key for signing the JWT token
    // In production, this should be stored securely (e.g., environment variables)
    private static final String SECRET_KEY = "placement-tracker-secret-key-for-jwt-token-generation-must-be-long-enough";
    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 24 hours in milliseconds

    // Generate a signing key from the secret key string
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    /**
     * Generate a JWT token for the given email (username)
     * 
     * @param email the user's email to be embedded in the token
     * @return the generated JWT token string
     */
    public String generateToken(String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(email) // Set the subject (email) in the token
                .setIssuedAt(now) // Set the issue date
                .setExpiration(expiryDate) // Set the expiration date
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // Sign with secret key
                .compact();
    }

    /**
     * Extract the username (email) from the JWT token
     * 
     * @param token the JWT token string
     * @return the username (email) extracted from the token
     */
    public String extractUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    /**
     * Validate the JWT token
     * Checks if the token is properly signed and not expired
     * 
     * @param token the JWT token string to validate
     * @return true if the token is valid, false otherwise
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // Token is invalid or expired
            return false;
        }
    }
}
