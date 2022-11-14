package sg.nus.csf.diaryspring.configs;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import sg.nus.csf.diaryspring.services.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
  
  // @Value("${jwt.public.key}")
	// RSAPublicKey key;

	// @Value("${jwt.private.key}")
	// RSAPrivateKey priv;

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public WebSecurityConfig(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Autowired
  public UserService userService;

  // @Bean
  // public SecurityFilterChain web(HttpSecurity http) throws Exception {
  //   http
  //     .authorizeHttpRequests(auth -> auth
  //       .anyRequest().authenticated())
  //     .csrf((csrf) -> csrf.ignoringRequestMatchers("/token"))
  //     .httpBasic(Customizer.withDefaults())
  //     .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
  //     .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
  //     .exceptionHandling((exceptions) -> exceptions
  //       .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
  //       .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
	// 		);
      
  //   return http.build();
  // }
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin().permitAll()
          .usernameParameter("username")
          .passwordParameter("password")
          .defaultSuccessUrl("/home",true);

    return http.build();
  }

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider(){
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder);
    provider.setUserDetailsService(userService);
    return provider;
  }

  // @Bean
	// JwtDecoder jwtDecoder() {
	// 	return NimbusJwtDecoder.withPublicKey(this.key).build();
	// }

  // @Bean
	// JwtEncoder jwtEncoder() {
	// 	JWK jwk = new RSAKey.Builder(this.key).privateKey(this.priv).build();
	// 	JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
	// 	return new NimbusJwtEncoder(jwks);
	// }
}