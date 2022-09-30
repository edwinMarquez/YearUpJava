package com.example.yearupSpring.configs;


import com.example.yearupSpring.models.User;
import com.example.yearupSpring.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


/**
 * this configuration is based on: https://spring.io/guides/gs/securing-web/
 *
 * @author edwin
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    UserRepository userRepo;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((requests) -> requests
                .antMatchers("/","/logout","/signup","/users","/resources/**")
                .permitAll()
                .anyRequest().authenticated()
        ).formLogin((form) -> form.loginPage("/login").defaultSuccessUrl("/",true).permitAll())
                .logout().logoutSuccessUrl("/")
                .and()
                .csrf().ignoringAntMatchers("/logout");

        return http.build();
    }

    @Bean
    public PasswordEncoder customPasswordEncoder(){
        return new CustomPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(customPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        return daoAuthenticationProvider;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepo.findByUsername(username);
                if(user == null)throw new UsernameNotFoundException("");
                UserDetails ud = org.springframework.security.core.userdetails.User.builder()
                        .roles("USER")
                        .username(user.getUsername())
                        .password(byteToBase64(user.getPassword()))
                        .build();
                return ud;
            }
        };
    }

    /**
     * This CustomPasswordEncoder is used to help showcase how password are stored on this project database
     * Spring security provides different mechanisms that will not only use a salt but will also be generated
     * per password.
     * https://docs.spring.io/spring-security/reference/features/authentication/password-storage.html
     */
    public static class CustomPasswordEncoder implements PasswordEncoder{

        MessageDigest messageDigest;

        public CustomPasswordEncoder(){
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String encode(CharSequence rawPassword) {
            StringBuilder realPassword = new StringBuilder();
            realPassword.append(rawPassword);
            realPassword.append("SALT_random_string");
            byte[] encoded = messageDigest.digest(realPassword.toString().getBytes(StandardCharsets.UTF_8));
            return byteToBase64(encoded);
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            return encode(rawPassword).equals(encodedPassword);
        }

        @Override
        public boolean upgradeEncoding(String encodedPassword) {
            return PasswordEncoder.super.upgradeEncoding(encodedPassword);
        }
    }

    private static String byteToBase64(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }

}
