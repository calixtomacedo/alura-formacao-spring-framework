package br.com.cmdev.springbootapirestiii.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.cmdev.springbootapirestiii.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${cmdev.jwt.expiration}")
	private String expiration;

	@Value("${cmdev.jwt.secret}")
	private String secret;

	public String generateToken(Authentication authentication) {
		Usuario loggedUser = (Usuario) authentication.getPrincipal();
		Date today = new Date();
		Date dateExpiration = new Date(today.getTime() + Long.parseLong(expiration));

		String token = Jwts.builder()
				.setIssuer("API do Curso REST com Spring Boot - CMDEV")
				.setSubject(loggedUser.getId().toString())
				.setIssuedAt(today)
				.setExpiration(dateExpiration)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();

		return token;
	}

	public Boolean isTokeValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}
