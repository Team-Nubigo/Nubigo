package com.teamprj.nubigo.config;

import com.teamprj.nubigo.jwt.JwtAuthenticationFilter;
import com.teamprj.nubigo.jwt.JwtAuthorizationFilter;
import com.teamprj.nubigo.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsConfig corsConfig;

    private final UserJpaRepository userJpaRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)// 세션을 사용하지 않겠다는 설정
                .and().addFilter(corsConfig.corsFilter()) // 필터 등록 / @CrossOrigin(인증이 X 때 사용) , SecurityFilter(인증이 있을 때 사용)
                .formLogin().disable()
                .httpBasic().disable()
                .addFilter(new JwtAuthenticationFilter(authenticationManager())) // 필터 등록 AuthenticationManager라는 것이 로그인을 진행해준다
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userJpaRepository)) // 필터 등록 AuthenticationManager라는 것이 로그인을 진행해준다
                .authorizeRequests()
                .antMatchers("/tourlist/**")
                .access("hasRole('ROLE_MEMBER')")
                .anyRequest().permitAll();

    }
}
