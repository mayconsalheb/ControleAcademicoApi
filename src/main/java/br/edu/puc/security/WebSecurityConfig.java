package br.edu.puc.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic()
			;
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder builder) throws Exception {
			builder
				.inMemoryAuthentication()
				.withUser("flavio")
				.password("{noop}123")
				.roles("ADM")
				.and()
				.withUser("jose")
				.password("{noop}321")
				.roles("ADM")
			;
		}
}
