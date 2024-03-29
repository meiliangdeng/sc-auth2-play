package me.coast.auth.server.config.flat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

import me.coast.auth.server.service.impl.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class TyWebSecurityConfig extends WebSecurityConfigurerAdapter {
 

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;


    @Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        // TODO Auto-generated method stub
        //auth.userDetailsService(userDetailsServiceImpl);
    //    auth.inMemoryAuthentication()
    //    .withUser("dengmeiliang1").password("123456").roles("ADMIN").authorities(new ArrayList<>(0));

        // .and()
        // .withUser("dengmeiliang2").password(passwordEncoder().encode("123456")).roles("ADMIN");
    // auth.inMemoryAuthentication()
    // .withUser("dengmeiliang1").password("123456").roles("USER")
    //  .and()
    //  .withUser("dengmeiliang2").password("123456").roles("ADMIN");

    }
}
