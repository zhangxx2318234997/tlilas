package com.itzhangxx;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;



class SpringbootTalisApplicationTests {

    @Test
    public void testJWT(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itzhangxx")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600*1000))
                .compact();
        System.out.println(jwt);
    }
// eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcxMzQ5ODk0MH0.BMGNVOdYgfjhpjQGll1h6ftacY1b9_kvZcCixvSCFSM
    @Test
    public void openJWT(){
        Claims claims = Jwts.parser()
                .setSigningKey("itzhangxx")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYWlIjoidG9tIiwiaWQiOjEsImV4cCI6MTcxMzQ5ODk0MH0.BMGNVOdYgfjhpjQGll1h6ftacY1b9_kvZcCixvSCFSM")
                .getBody();
        System.out.println(claims);
    }
}
