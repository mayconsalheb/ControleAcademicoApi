package br.edu.puc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.edu.puc.security.jwt.JWTAuthenticationFilter;
import br.edu.puc.security.jwt.JWTLoginFilter;
import br.edu.puc.util.ConstantsEnum;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
		@Autowired
		private ControleAcademicoUserDetailsService userDetailsService;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		    CorsConfiguration config = new CorsConfiguration();
		    config.setAllowCredentials(true);
		    config.addAllowedOrigin("*");
		    config.addAllowedHeader("*");
		    config.addAllowedMethod("*");
		    config.addExposedHeader(ConstantsEnum.AUTHENTICATION_HEADER.getValue());
		    source.registerCorsConfiguration("/**", config);
		    
			http
				.cors()
				.configurationSource(source)
	            .and()
	            .csrf().disable()
				.authorizeRequests()
				.antMatchers("/console/**")
				.permitAll()
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
