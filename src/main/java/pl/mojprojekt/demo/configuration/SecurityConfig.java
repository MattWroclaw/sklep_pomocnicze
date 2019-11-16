package pl.mojprojekt.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index", "/").permitAll()
                .antMatchers("register").permitAll()
                .antMatchers("/sklep").hasAnyRole("ADMIN", "USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .and().csrf().disable()
                .formLogin()
//                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/")
                .usernameParameter("loginMail")
                .passwordParameter("haslo")
                .and().logout()
                .logoutSuccessUrl("/left")
                .and().exceptionHandling().accessDeniedPage("/denied")
                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
