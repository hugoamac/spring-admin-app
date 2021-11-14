package br.com.hugoamac.catalogo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthenticateConfig extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	public AuthenticateConfig(UserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
			
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin/**").hasAnyRole("ADMIN", "USER")
		.antMatchers("/**").permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/admin/dashboard");
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
