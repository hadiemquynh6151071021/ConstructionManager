package com.construction.cmsfresher.security.jwt;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
	private final String JWT_SECRET = "lodaaaaaa";

	private final long JWT_EXPIRATION = 84000000;

	public String generateToken(Authentication auth) {
		Date now = new Date();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		return Jwts.builder().setSubject((userDetails.getUsername())).setIssuedAt(now)
				.setExpiration(new Date(new Date().getTime() + JWT_EXPIRATION))
				.signWith(SignatureAlgorithm.HS256, JWT_SECRET).compact();
	}

	public String getUserNameFromJWT(String token) {
		String username = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
		return username;
	}

	public Boolean validateToken(String jwt) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(jwt);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
