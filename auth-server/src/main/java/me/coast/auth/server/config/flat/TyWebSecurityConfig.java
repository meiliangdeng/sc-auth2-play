package me.coast.auth.server.config.flat;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
@EnableWebSecurity
public class TyWebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    // @Bean
    // @Override
    // public AuthenticationManager authenticationManagerBean() throws Exception {
    //     return super.authenticationManagerBean();
    // }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
                http.formLogin()
                        .and()
                        .authorizeRequests();
        registry.antMatchers("/oauth/**").permitAll();
        registry.antMatchers("/login/**").permitAll();
        registry.antMatchers("/logout/**").permitAll();
        
        registry.anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
