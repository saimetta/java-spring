package io.santiago.springcourse;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Tell spring to enable web security, to filter and authenticate web requests
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * Authentication
	 * by extending WebSecurityConfigurerAdapter we deal with an wrapped version of the AuthenticationManagerBuilder
	 * to configure the AuthenticationManager, in this case will be focused on the web layer
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//here we configure the AuthenticationManagerBuilder to authenticate in memory
		//the hardcoded user
		auth.inMemoryAuthentication().withUser("Tino")
									 .password("1234")
									 .roles("ADMIN")
									 .and()
									 .withUser("San")
									 .password("567")
									 .roles("USER");
	}
	
	/**
	 * Spring does not deal with plain text passwords, you need to define a bean
	 * to handle the password encoding, as an example NoOpPasswordEncoder is used.
	 * What it does is to leave the passoword as plain text and does not encode it
	 */
	@Bean
	public PasswordEncoder passwordEncoder() { 
		return NoOpPasswordEncoder.getInstance();
	}
	/**
	 * Authorization
	 * Similar to the configure to set up the AuthenticationManager, this configure will set the HttpSecurity
	 * which is the object to set up the authorization (roles and authority grants)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//antMatchers is used to match any url to apply the role and a login method
		    //rules should be applied from most specific to more general
		    //It uses ant wildcards, for example al routes will be /**
			.antMatchers("/api/admin").hasRole("ADMIN")
			.antMatchers("/api/user").hasAnyRole("ADMIN", "USER")
			//permitAll() allows any role, it could be used for static pages,
			//assets like css or js that not need authentication
			.antMatchers("/api/").permitAll() 
			.and().formLogin();
			
	}
}
