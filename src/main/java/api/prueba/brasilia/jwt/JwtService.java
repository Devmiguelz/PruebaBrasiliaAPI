package api.prueba.brasilia.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final String LlAVE_SECRETA = "FcturacionSR12023FcturacionSR12023FturacionSR12023";

    private static final long TIEMPO_EXPIRATION = 3600_000;

    public String getToken(UserDetails usuario) {
        return getTokenJWT(new HashMap<>(), usuario);
    }

    public boolean validateTokenJWT(String token) {
        try {
            Jwts.parser()
                    .verifyWith((SecretKey) getSigningKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private String getTokenJWT(Map<String, Object> claims, UserDetails usuario) {
        return Jwts.builder()
                .claims(claims)
                .subject(usuario.getUsername())
                .expiration(Date.from(Instant.now().plusMillis(TIEMPO_EXPIRATION)))
                .signWith(getSigningKey())
                .compact();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(LlAVE_SECRETA);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private <T> T getClaim(String token, Function<Claims,T> claimsResolver)
    {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token)
    {
        return Jwts
                .parser()
                .verifyWith((SecretKey) getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Date getExpiration(String token)
    {
        return getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token)
    {
        return getExpiration(token).before(new Date());
    }
}
