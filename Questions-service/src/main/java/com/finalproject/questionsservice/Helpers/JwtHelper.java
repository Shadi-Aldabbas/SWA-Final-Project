package com.finalproject.questionsservice.Helpers;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalproject.questionsservice.dto.AnswerDto;
import com.finalproject.questionsservice.dto.TokenDto;
import io.jsonwebtoken.*;
public class JwtHelper {

    private final String secret = "top-secret";
    private final long expirataion = 5 * 60 * 60 * 60;

    public String generateToken(String email, TokenDto tokenDto){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirataion))
                .claim("user", tokenDto)
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

   public String parseToken(String token) {
        return token.split("")[1];
   }

    public String getSubject(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public TokenDto getUserFromToken(String token){
        ObjectMapper mapper= new ObjectMapper();
        Object claim = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token).getBody().get("user");

        var result = mapper.convertValue(claim, TokenDto.class);
        return result;
    }

}