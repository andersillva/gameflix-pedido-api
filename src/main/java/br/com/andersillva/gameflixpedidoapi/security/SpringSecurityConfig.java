package br.com.andersillva.gameflixpedidoapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true, jsr250Enabled=true, prePostEnabled=true)
@Configuration
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, TokenService tokenService) throws Exception {

        http.authorizeRequests()
    		.anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
    		.and().csrf().disable()
    		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    		.and().addFilterBefore(new TokenAuthenticationFilter(tokenService), UsernamePasswordAuthenticationFilter.class);

		http.headers().frameOptions().sameOrigin();

		return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().antMatchers(
	        		"/v3/api-docs/**",
	        		"/swagger-ui.html",
	        		"/swagger-ui/**"
        		);
    }

}
