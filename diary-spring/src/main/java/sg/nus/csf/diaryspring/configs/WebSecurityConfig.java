package sg.nus.csf.diaryspring.configs;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.authentication.AuthenticationManager; 
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; 

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
  @Bean 
  public PasswordEncoder passwordEncoder() { 
    return new BCryptPasswordEncoder(); 
  }

  @Bean
  public SecurityFilterChain web(HttpSecurity http) throws Exception {
    http
      .httpBasic()
    .and()
      .authorizeRequests().antMatchers("/index.html", "/", "/home", "/login").permitAll()
      .anyRequest().authenticated();

    return http.build();
  }
}