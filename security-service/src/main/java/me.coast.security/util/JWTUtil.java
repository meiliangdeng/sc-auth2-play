package me.coast.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

//参考：https://www.cnblogs.com/wangrongwen/p/13682107.html
public class JWTUtil {
    public static void main(String[] args) {
        try {

            Calendar instance = Calendar.getInstance();
            instance.add(Calendar.MINUTE,30);
            String token = JWT.create()
                    .withClaim("userid","meiliangdeng")//添加payload
                    .withClaim("username","1232")
                    .withClaim("email","meiliangdeng")
                    .withExpiresAt(instance.getTime())//设置过期时间
                    .sign(Algorithm.HMAC256("testjwt"));//设置签名 密钥
            System.out.println("token="+token);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }
    }
}
