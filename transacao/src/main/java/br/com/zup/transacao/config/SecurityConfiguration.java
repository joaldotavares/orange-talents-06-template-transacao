package br.com.zup.transacao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable().csrf().disable()
				.authorizeRequests(authorize -> authorize.antMatchers(HttpMethod.GET, "/transacao/**").permitAll()
						.anyRequest().authenticated())
				.headers().frameOptions().disable().and().cors().and()
				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
