package com.example.demo.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;
import com.example.demo.dto.LoginDto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TokenUtil {
    private static final String TOKEN_SECRET = "StringDatabase";

    public String createToken(int Id)   {
        try {
            //to set algorithm
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            String token = JWT.create()
                    .withClaim("user_id", Id)
                    .sign(algorithm);
            return token;

        } catch (JWTCreationException exception) {
            exception.printStackTrace();
            //log Token Signing Failed
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param token
     * @return
     */
    public int decodeToken(String token)
    {
        int userid;
        //for verification algorithm
        Verification verification = null;
        try {
            verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException  e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JWTVerifier jwtverifier=verification.build();
        //to decode token
        DecodedJWT decodedjwt=jwtverifier.verify(token);

        Claim claim=decodedjwt.getClaim("user_id");
        userid= claim.asInt();
        return userid;

    }


	
//	public String generateToken(String email, String password) {
//		Map<String, Object> claims = new HashMap<>();
//		claims.put("Email", email);
//		claims.put("Password", password);
//
//		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
//	}
//   
}