package com.ahmet.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthServiceSecurityConfig {

    @Bean
    JwtTokenFilter getJwtTokenFilter(){
        return new JwtTokenFilter();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf().disable(); // csrf'i kapattık, ihtiyaç yok. Çünkü artık kendi güvenliğimizi kendimiz yazıyoruz.
        httpSecurity.authorizeRequests().antMatchers("/v3/api-docs/**","/swagger-ui/**","/api/v1/auth/login", "/api/v1/auth/findall", "/api/v1/auth/register","/api/v1/auth/register2","/api/v1/auth/activatestatus").permitAll().anyRequest().authenticated(); // bu url'lere izin ver. Diğer tüm istekler için authentication uygula (kimlik doğrulama yap). ||| Söz dizimi şöyle olsaydı tam ters mantık olurdu: .authenticated().anyRequest().permitAll(); --> yazılan url'ler için kimlik doğrulama yap, diğer tüm url'lere izin ver.
//        httpSecurity.formLogin();

        httpSecurity.addFilterBefore(getJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class); // önce, token olup olmadığını kontrol ediyor (request header'ında)
        return httpSecurity.build();
    }

}
