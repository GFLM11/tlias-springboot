package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Consumer;

@SpringBootTest
class TliasApplicationTests {

    /*@Test
    void contextLoads() {
        Date date = new Date(1000);
        System.out.println(date);
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "Tom");
        Set<Map.Entry<String, Object>> entrySet = claims.entrySet();
        entrySet.forEach(stringObjectEntry -> {
                String key = stringObjectEntry.getKey();
                Object value = stringObjectEntry.getValue();
                System.out.println("key：" + key + ";" + "value：" + value);
            }
        );
    }

    @Test
    public void testUUID() {
        for (int i = 0; i < 100; i++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }

    @Test
    public void testJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "Tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itheima")  //设置签名算法
                .setClaims(claims)  //设置载荷
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 30))) //设置jwt有效期
                .compact();
        System.out.println(jwt);
    }

    //    eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjg4MDQ1Nzg4LCJ1c2VybmFtZSI6IlRvbSJ9.k6nrk_Yok_JCC5tbHUx_XphJJVt--USq-Zzc0LxyJNw
    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjg4MDQ1Nzg4LCJ1c2VybmFtZSI6IlRvbSJ9.k6nrk_Yok_JCC5tbHUx_XphJJVt--USq-Zzc0LxyJNw")
                .getBody();
        System.out.println(claims);
    }*/
}
