package br.edu.puc.security.jwt;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.edu.puc.util.ConstantsEnum;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
	
	// EXPIRATION_TIME = 10 dias
	static final long EXPIRATION_TIME = 860_000_000;
	static final String SECRET = "MySecret";
	static final String TOKEN_PREFIX = "Bearer";
								  
	public static void addAuthentication(HttpServletResponse resp, String userName){
		String JWT = Jwts.builder()
						.setSubject(userName)
						.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
						.signWith(SignatureAlgorithm.HS256, SECRET)
						.compact();
		
		resp.addHeader(ConstantsEnum.AUTHENTICATION_HEADER.getValue(), TOKEN_PREFIX+" "+JWT);
	}
	
	public static Authentication getAuthentication(HttpServletRequest req){
		String token = req.getHeader(ConstantsEnum.AUTHENTICATION_HEADER.getValue());
		
		if(token != null){
			String userName = Jwts.parser()
								.setSigningKey(SECRET)
								.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
								.getBody()
								.getSubject();
			
			if(userName != null){
				return new UsernamePasswordAuthenticationToken(userName, null, Collections.emptyList());
			}
		}
		
		return null;
	}

}
