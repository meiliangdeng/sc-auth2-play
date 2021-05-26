package me.coast.auth.server.config.flat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class FlatWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * 配置内存登陆用户认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder.encode("123456")).roles("ADMIN")
                .and()
                .withUser("user").password(passwordEncoder.encode("123456")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth/**","/login/**", "/logout").permitAll()
                .anyRequest().authenticated()   // 其他地址的访问均需验证权限
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/");
    }
}
