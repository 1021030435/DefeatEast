package com.app.utils;

import java.util.Date;
import java.util.Map;

import com.app.base.AppConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JavaWebToken {

	private static final SignatureAlgorithm ALG = SignatureAlgorithm.HS512;
	
	//private static final String KEY = "token";
	
	private static final String SIGN_WITH = "TSf8DwJAQRo6XN/dfM45xQ==";
	
	private static final String SUB = "userLogin";

	public static String getToken(Map<String, Object> claims) throws Exception {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(SUB);
		builder.setClaims(claims);
		builder.signWith(ALG, SIGN_WITH);
		builder.setExpiration(new Date(System.currentTimeMillis() + AppConfig.JWT_EXPIRE_TIME));
		return builder.compact();
	}

	private static Jws<Claims> getJws(String token) throws Exception {
		return Jwts.parser().setSigningKey(SIGN_WITH).parseClaimsJws(token);
	}

	public static Map<String, Object> getMap(String token) throws Exception {
		Jws<Claims> jws = getJws(token);
		return jws.getBody();
	}

	public static Integer getJobId(String token) throws Exception {
		return (Integer) getMap(token).get(AppConfig.JWT_MAP_KEY);
	}
}
