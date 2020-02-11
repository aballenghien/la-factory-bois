package fr.lafactory.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.lafactory.model.Role;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter {
		//CONFIGURATION DES ACCES POUR L'API
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/api/**").authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS).permitAll()
				.antMatchers("/**").hasAnyRole("ADMINISTRATEUR", "TECHNICIEN")
				.and().httpBasic()
				.and().csrf().disable();
		}
	}
	
	
	@Configuration
	public static class FormLoginWebSecurityConfig extends WebSecurityConfigurerAdapter {
		//CONFIGURATION DES ACCES
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
				.antMatchers("/assets/**").permitAll()
				.antMatchers("/**").hasAnyRole("ADMINISTRATEUR", "TECHNICIEN")
				.and()
				.formLogin()
					.loginPage("/login")
					.loginProcessingUrl("/performLogin")
					.defaultSuccessUrl("/modele", true)
					.failureUrl("/login?error=true")
					.permitAll();
		}
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}






//package fr.formation.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter   {
//	@Autowired
//	private AuthService authService;
//	
//	//Configuration des acces
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/assets/**").permitAll()
//		.antMatchers("/api/**").permitAll() // CONFIG TEMPORAIRE ANGULAR
//		.antMatchers("/**").hasAnyRole("ADMIN", "MUSICIEN")
//		.and()
//		.formLogin()
//			.loginPage("/login")
//			.loginProcessingUrl("/performLogin")
//			.defaultSuccessUrl("/listeProduit", true)
//			.failureUrl("/login?error=true")
//			.permitAll()
//		.and()
//		.csrf().disable();
//
//	}
//	
//	// Configuration des utilisateurs
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.inMemoryAuthentication()
////		.withUser("admin").password("{noop}123").roles("ADMIN")
////		.and()
////		.withUser("unmusicien").password("{noop}123").roles("MUSICIEN");
//		
//		auth.userDetailsService(this.authService);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}
