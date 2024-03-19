package com.ayd2.hotel.service.jwt;

import com.ayd2.hotel.security.KeyLoader;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Date;

@Service
public class JwtService {

    @Value("${security.jwt.public.key}")
    private String PUBLIC_KEY;

    @Value("${security.jwt.private.key}")
    private String PRIVATE_KEY;

    @Value("${security.jwt.secret.key}")
    private String SECRET_KEY;

    @Value("${security.jwt.ttlMillis}")
    private Long TTL_MILLIS;

    @Value("${security.jwt.issuer}")
    private String ISSUER;

    public String generateToken(String username) throws IOException {
        return Jwts
                .builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + TTL_MILLIS))
                .issuer(ISSUER)
                .signWith(getSecretKey())
                .compact();
    }

    public String getUsername(String token) throws IOException {
        var claims = extractClaims(token);
        return claims.getSubject();
    }

    public boolean isValid(String token) throws IOException {
        var claims = extractClaims(token);
        var expiration = claims.getExpiration();
        return new Date().before(expiration);
    }

    private Claims extractClaims(String token) throws IOException {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
