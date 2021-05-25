package me.coast.auth.server.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BCryptPasswordEncoderTests {


    @Test
    public void contextLoads() {
    }


    @Test
    public void testBCryptPasswordEncoder (){
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));

    }


}
