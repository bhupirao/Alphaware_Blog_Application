//package com.alphaware.AppConfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth ->{
//                    auth
//                            .requestMatchers(HttpMethod.POST,"/api/posts").permitAll()
//                            .requestMatchers(HttpMethod.GET, "/api/posts","/api/comments").hasRole("ADMIN")
//                            .requestMatchers(HttpMethod.GET, "/api/users/**").hasAnyRole("ADMIN","USER")
//                            .anyRequest().authenticated();
//                }).addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
//                .csrf(csrf -> csrf.disable())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
