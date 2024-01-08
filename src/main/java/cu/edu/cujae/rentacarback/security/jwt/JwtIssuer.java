package cu.edu.cujae.rentacarback.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import cu.edu.cujae.rentacarback.security.config.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class JwtIssuer {
    @Autowired
    private JwtProperties jwtProperties;
    public String issue(String username, String email, List<String> role) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(Instant.now().plus(Duration.of(1, ChronoUnit.DAYS)))
                .withClaim("e", email)
                .withClaim("r", role)
                .sign(Algorithm.HMAC256(jwtProperties.getSecretKey()));
    }
}
