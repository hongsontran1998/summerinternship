package com.demo.configuration;

import com.demo.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;

//https://spring.io/guides/gs/securing-web/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        BCryptPasswordEncoder encoder = passwordEncoder();
        //create user for demo
//        auth.
//                inMemoryAuthentication()
//                    .withUser("admin")
//                    .password(encoder.encode("123"))
//                    .roles("ADMIN")
//                    .and()
//                    .passwordEncoder(encoder);
        //authenticate from database
        auth.inMemoryAuthentication();//phải có dòng này chứ không là nó lấy form login mặc định
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);;;
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*jwt*/
        /*http.authorizeRequests().anyRequest().authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER);*/
//        super.configure(http);
        http.authorizeRequests().antMatchers("/demo").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/abc/**").access("hasAnyRole('ROLE_AMDIN', 'ROLE_USER')");
        http.authorizeRequests()
                .antMatchers("/api/*", "/logout", "/login").permitAll();
        //những trang còn lại được bảo vệ
        //http.authorizeRequests().anyRequest().authenticated();
        //những trang còn lại ai vào cũng được vd ở phần public
        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        http
            .cors().and()/*rest api*/
            .csrf().and() //csrf
            //.httpBasic() //cách nhanh không dùng form như ở dưới
            .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/demo", false) //false: always-use-default-target="false"
                .failureUrl("/login?error=loginErr")
//                .successHandler()
//                .failureHandler()
                .and()
            .logout()
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
