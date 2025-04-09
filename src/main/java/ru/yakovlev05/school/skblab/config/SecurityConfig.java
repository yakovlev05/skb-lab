package ru.yakovlev05.school.skblab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(r -> r
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/support/**").hasRole("SUPPORT")
                        .requestMatchers("/public/**").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .passwordEncoder(passwordEncoder::encode)
                .build();

        UserDetails support = User.builder()
                .username("support")
                .password("support")
                .roles("SUPPORT")
                .passwordEncoder(passwordEncoder::encode)
                .build();

        UserDetails superuser = User.builder()
                .username("superuser")
                .password("superuser")
                .roles("SUPPORT", "ADMIN")
                .passwordEncoder(passwordEncoder::encode)
                .build();

        return new InMemoryUserDetailsManager(admin, support, superuser);
    }

}
