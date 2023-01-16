package com.sda.bookstore.project.config;

import com.sda.bookstore.project.repository.UserRepository;
import com.sda.bookstore.project.service.UserService;
import com.sda.bookstore.project.service.impl.PasswordService;
import com.sda.bookstore.project.service.impl.UserSecurityService;
import com.sda.bookstore.project.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.sda.bookstore.project.utility.SecurityUtility.passwordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private Environment env;
    @Autowired
    PasswordService passwordService;

    @Autowired
    UserService userService;

    @Autowired
    SecurityUtility securityUtility;

    @Bean
    public UserDetailsService userDetailsService() {

        return new UserSecurityService();
    }

    private static final String[] PUBLIC_MATCHERS = {
            "/css/**",
            "/js/**",
            "/image/**",
            "/home/**",
            "/newUser",
            "/forgetPassword",
            "/login",
            "/fonts/**",
            "/bookshelf",
            "/bookDetail/**",
            "/hours",
            "/faq",
            "/searchByCategory",
            "/searchBook",
            "/"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().cors().disable()
                .formLogin().failureUrl("/login?error")
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll()
                .and()
                .rememberMe();
        http.authorizeHttpRequests()
                .mvcMatchers(PUBLIC_MATCHERS)
                .permitAll()
                .mvcMatchers("/home/**", "/adminhome/**", "/book/**", "/myAdmin").hasAuthority("ROLE_ADMIN")
                .mvcMatchers("/home/**", "/check/**", "/search/**", "/shoppingCart/**").hasAuthority("ROLE_USER")
                .anyRequest()
                //.authenticated();
                .permitAll();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsPasswordService(passwordService);
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }

}




