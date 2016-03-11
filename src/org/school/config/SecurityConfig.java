package org.school.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().passwordEncoder(passwordEncoder).dataSource(dataSource)
				.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
				.authoritiesByUsernameQuery("SELECT username, authority FROM users WHERE username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/test1").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/registrationForm").permitAll()
		.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/home").authenticated()
		.antMatchers("/test2").authenticated()
		.antMatchers("/").permitAll()
		.anyRequest().denyAll()
		.and()
		.formLogin().loginPage("/login")
		.usernameParameter("username")
		.passwordParameter("password")
		.defaultSuccessUrl("/home")
		.and()
		.logout()
        .deleteCookies("remove")
        .invalidateHttpSession(true)
        .logoutUrl("/logout")
        .logoutSuccessUrl("/home")
    .permitAll();
	}

}
