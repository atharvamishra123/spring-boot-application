package com.demo.shopping.com.ApplicationConfiguration;

import com.demo.shopping.com.ApplicationConfiguration.SecurityServices.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().and()
                .authorizeRequests().antMatchers("/www.shopping.com/**"
                                                       ,"/images/**"
                                                       ,"/webjars")
                .permitAll()
                .and()

                .authorizeRequests().antMatchers("/addtocart/**")
                .authenticated()
                .anyRequest()
                .hasAnyRole("read")
                .and()

                .formLogin()
                    // .loginPage("/login")
                   //  .usernameParameter("username")
                     .permitAll()
                .and()
                .logout().permitAll();
    }
}
