package com.SWAFinalProject.userservice.helpers;

import java.util.Date;

import com.SWAFinalProject.userservice.dto.TokenDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
public class JwtHelper {

    private final String secret = "very-secret";
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
        var tkn = parseToken(token);
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(tkn);
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
        return token.split(" ")[1];
    }

    public String getSubject(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public TokenDto getUserFromToken(String token){
        var tkn = parseToken(token);
        ObjectMapper mapper= new ObjectMapper();
        Object claim = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(tkn).getBody().get("user");

        var result = mapper.convertValue(claim, TokenDto.class);
        return result;
    }

}
