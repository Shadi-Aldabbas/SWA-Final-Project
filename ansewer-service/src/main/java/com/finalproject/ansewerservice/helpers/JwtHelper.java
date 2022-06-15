package com.finalproject.ansewerservice.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalproject.ansewerservice.dto.UserDto;
import io.jsonwebtoken.*;

import java.util.Date;


public class JwtHelper {
    private final String secret = "very-secret";
    private final long expirataion = 5 * 60 * 60 * 60;



    public String generateToken(String email, UserDto userDto) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirataion))
                .claim("user", userDto)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            System.out.println(e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println(e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println(e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String parseToken(String token){
        return token.split(" ")[1];
    }

    public String getSubject(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public UserDto getUserFromToken(String token) {

        ObjectMapper mapper = new ObjectMapper();
        Object claim = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token).getBody().get("user");

        var result = mapper.convertValue(claim,UserDto.class);
        return result;
    }
}
