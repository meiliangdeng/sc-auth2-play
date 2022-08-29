package me.coast.auth.server.config.flat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import me.coast.auth.server.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableAuthorizationServer
@Order(Integer.MIN_VALUE)
public class TyAuthServerConfig extends AuthorizationServerConfigurerAdapter {
    
    private TokenStore tokenStore = new InMemoryTokenStore();
	
	
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;
    
	@Autowired
	private AuthenticationManager authenticationManager;
    
 
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        clients.inMemory()
        .withClient("client1")
        //.secret(passwordEncoder.encode("server1"))
        .secret("server1")
        //.authorizedGrantTypes("refresh_token", "password", "authorization_code")
        .authorizedGrantTypes("password")
        .scopes("server");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
		//endpoints.userDetailsService(userDetailsService);
		// 配置Token的存储方式
		endpoints.tokenStore(tokenStore)
			// 注入WebSecurityConfig配置的bean
			.authenticationManager(authenticationManager);
        endpoints.userDetailsService(userDetailsServiceImpl);

	}


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .allowFormAuthenticationForClients()
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()");
    }

}
