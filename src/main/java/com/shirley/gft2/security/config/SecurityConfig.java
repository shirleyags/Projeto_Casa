package com.shirley.gft2.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/imagens/**", "/js/**", "/css/**").permitAll()
				.antMatchers("/index").permitAll().antMatchers("/casa/**","/eventos/cadastrareventos").hasAuthority("ADMIN")
				.antMatchers("/eventos/cadastrareventos/listaeventos").hasAnyAuthority("CLIENTE","ADMIN")
				.anyRequest().authenticated()

				.and().formLogin().loginPage("/login").defaultSuccessUrl("/index", true).failureUrl("/login-error")
				.permitAll().and().logout().logoutSuccessUrl("/index")
				.and().exceptionHandling().accessDeniedPage("/acesso-negado")
		;

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("admin.henrique").password(encoder.encode("123")).authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("usuario.cliente").password(encoder.encode("123")).authorities("CLIENTE");

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/js/**", "/css/**");

	}
}
