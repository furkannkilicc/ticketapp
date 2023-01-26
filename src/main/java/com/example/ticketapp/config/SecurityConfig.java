package com.example.ticketapp.config;

import com.example.ticketapp.security.JwtAuthenticationEntryPoint;
import com.example.ticketapp.security.JwtAuthenticationFilter;
import com.example.ticketapp.services.UserDetailServiceImp;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private UserDetailServiceImp userDetailServiceImp;
    private  JwtAuthenticationEntryPoint handler;

    public SecurityConfig(UserDetailServiceImp userDetailServiceImp, JwtAuthenticationEntryPoint handler) {
        this.userDetailServiceImp = userDetailServiceImp;
        this.handler = handler;
    }

    //BEANS
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(){
        return new JwtAuthenticationFilter();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
//    CORS FİLTRE PARAMETRELERI
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
       JwtAuthenticationEntryPoint handler;
        httpSecurity
                .cors()
                .and()
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(handler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests()
                .antMatchers("/tickets")
                .hasAnyRole("admin","user")
                .antMatchers( "/users")
                .hasAnyRole("admin")
                .antMatchers( "/seats")
                .hasAnyRole("admin")
                .antMatchers( "/routes")
                .hasAnyRole("admin")
                .and()
                .authorizeHttpRequests()
                .antMatchers("/auth/**")
                .antMatchers("/login")
                .antMathers("/admin/**")
                .hasAnyrole("admin")
                .permitAll()
                .anyRequest().authenticated();
            //jwt filtreyi eklendi
        httpSecurity.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
