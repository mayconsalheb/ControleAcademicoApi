package br.edu.puc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.edu.puc.security.jwt.JWTAuthenticationFilter;
import br.edu.puc.security.jwt.JWTLoginFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
		@Autowired
		private ControleAcademicoUserDetailsService userDetailsService;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.cors()
	            .and()
	            .csrf().disable()
				.authorizeRequests()
				.antMatchers("/login")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
		                UsernamePasswordAuthenticationFilter.class)
				
				.addFilterBefore(new JWTAuthenticationFilter(),
		                UsernamePasswordAuthenticationFilter.class)
			;
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder builder) throws Exception {
			builder
				.userDetailsService(userDetailsService)
				.passwordEncoder(new BCryptPasswordEncoder());
			
		}
}
