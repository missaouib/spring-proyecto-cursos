package com.fisi.proyectocursos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fisi.proyectocursos.security.config.MySimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Qualifier("userDetailsServiceImpl")
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
    
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
    	return new MySimpleUrlAuthenticationSuccessHandler();
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/").permitAll() 
				.antMatchers("/css/**", "/js/**", "/media/**", "/plugins/**", "/registro**", "/recuperacion**").permitAll()
				.antMatchers(HttpMethod.GET, "/catalogo/**").hasRole("CENTER")
				.antMatchers(HttpMethod.POST, "/catalogo/**").hasRole("CENTER")
				.antMatchers("/usuario/**").hasRole("USER")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.successHandler(myAuthenticationSuccessHandler())
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}
    
    
    

}
