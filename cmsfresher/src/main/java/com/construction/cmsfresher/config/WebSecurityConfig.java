package com.construction.cmsfresher.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.construction.cmsfresher.constant.RoleConstant;
import com.construction.cmsfresher.exception.CustomAccessDeniedHandler;
import com.construction.cmsfresher.security.jwt.JWTEntryPoint;
import com.construction.cmsfresher.security.jwt.JWTTokenFillter;
import com.construction.cmsfresher.security.userdetail.UserDetailServiceImpl;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;

	@Autowired
	JWTEntryPoint entryPoint;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling().authenticationEntryPoint(entryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.requestMatchers(AntPathRequestMatcher.antMatcher("/api/**")).permitAll()
				.requestMatchers(AntPathRequestMatcher.antMatcher("/api/auth/list"))
				.hasAnyAuthority(RoleConstant.TRUONG_NHOM).anyRequest().authenticated().and().exceptionHandling()
				.accessDeniedHandler(new CustomAccessDeniedHandler());
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JWTTokenFillter jwtAuthenticationFilter() {
		return new JWTTokenFillter();
	}
}