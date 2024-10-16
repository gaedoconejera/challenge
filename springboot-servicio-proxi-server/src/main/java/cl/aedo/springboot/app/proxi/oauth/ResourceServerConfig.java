package cl.aedo.springboot.app.proxi.oauth;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@RefreshScope
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
	 http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/security/oauth/**").permitAll()
							 .antMatchers(HttpMethod.GET,"/api/usuarios/usuarios/").permitAll()
						     .antMatchers(HttpMethod.GET,"/api/usuarios/usuarios/{id}").hasAnyRole("ADMIN", "USER")
						     .antMatchers(HttpMethod.POST,"/api/usuarios/usuarios/").hasRole("ADMIN")
						     .anyRequest().authenticated();
						   //.and().cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
    JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	
    @Bean
    JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("algun_codigo_secreto_aeiou");
		return tokenConverter;
	}

}