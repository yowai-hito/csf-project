package sg.nus.csf.diaryspring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sg.nus.csf.diaryspring.models.AppUser;
import sg.nus.csf.diaryspring.models.RegistrationRequest;
import sg.nus.csf.diaryspring.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
  
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<AppUser> appUser = userRepository.selectAppUserByUsername(username);
    if (appUser.isEmpty()) {
      throw new UsernameNotFoundException(username);
    }
    else {
      return appUser.get();
    }
  }

  public ResponseEntity<Object> registerUser(RegistrationRequest req) {
    Object responseBody = new Object();
    HttpHeaders responseHeaders = new HttpHeaders();
    HttpStatus responseStatus = HttpStatus.resolve(200);

    AppUser newUser = new AppUser(req.getUsername(), this.passwordEncoder.encode(req.getPassword()), req.getHandle(), req.getEmail());
    userRepository.registerUser(newUser);

    responseHeaders.set("Content-Type","application/json");
    responseHeaders.set("Accept", "application/json");
    
    return new ResponseEntity<>(responseBody, responseHeaders, responseStatus);
  }
}
