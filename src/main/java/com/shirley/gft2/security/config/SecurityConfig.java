package com.shirley.gft2.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/imagens/**","/js/**","/css/**").permitAll()
		.antMatchers("/index").permitAll()
		.antMatchers("/casa/**","/eventos/**","/templates/**").hasAuthority("ADMIN")
		//.antMatchers("/Eventos/listaEventosClientes").hasAuthority("CLIENTE")

		
		
		
		.anyRequest() .authenticated()
		
		.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/index", true)
			.failureUrl("/login-error")
			.permitAll()
		.and()
			.logout()
			.logoutSuccessUrl("/index")
		.and()
			.exceptionHandling()
			.accessDeniedPage("/acesso-negado")
			
		
		
			
			;
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser("shirley").password(encoder.encode("123")).authorities("ADMIN");
		auth.inMemoryAuthentication()
		.withUser("shirleyags").password(encoder.encode("123")).authorities("CLIENTE");

		

	}

	
	


}
