package com.saleit.security.jwt;

import java.util.HashMap;
import java.util.Map;

import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

public class JWTTokenProcessor {
	
	private static Map<String, RsaJsonWebKey> rsaJsonWebKeyContext = null;
	
	private JWTTokenProcessor() {}
	
	public static String generateToken(String userName, String Password) {
		String token = null;
		try {
			if(rsaJsonWebKeyContext == null) {
				rsaJsonWebKeyContext = new HashMap<String, RsaJsonWebKey>();
			}
			RsaJsonWebKey rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
			rsaJsonWebKey.setKeyId(userName);
			rsaJsonWebKeyContext.put(userName, rsaJsonWebKey);
			
			JwtClaims claims = new JwtClaims();
			claims.setIssuer("sastechnoservices");
			claims.setAudience(userName);
			claims.setIssuedAtToNow();
			claims.setClaim("status", "A");
			claims.setExpirationTimeMinutesInTheFuture(152600);
			
			JsonWebSignature jws = new JsonWebSignature();
			jws.setPayload(claims.toJson());
			jws.setKey(rsaJsonWebKey.getPrivateKey());
			jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());
			jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
			token = jws.getCompactSerialization();
			
		} catch (JoseException e) {
			e.printStackTrace();
		}
		return token;
	}
	
	public static Boolean isTokenValidForUser(String token, String userName) {
		Boolean isValid = false;
		JwtConsumer jwtConsumer = new JwtConsumerBuilder()
				.setRequireExpirationTime()
				.setExpectedIssuer("sastechnoservices")
				.setExpectedAudience(userName)
				.setVerificationKey(rsaJsonWebKeyContext.get(userName).getKey())
				.build();
		try {
			JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
			isValid = true;
		} catch (InvalidJwtException e) {
			e.printStackTrace();
		}
		return isValid;
	}

}
