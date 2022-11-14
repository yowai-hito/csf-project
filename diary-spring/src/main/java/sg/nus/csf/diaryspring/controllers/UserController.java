package sg.nus.csf.diaryspring.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.nus.csf.diaryspring.models.RegistrationRequest;
import sg.nus.csf.diaryspring.services.UserService;

@RestController
@RequestMapping(path="/diary/spring/user")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }
  
  @PostMapping("/userDetails")
  public Principal authenticatedUser(@RequestBody Principal user) {
    return user;
  }

  @PostMapping("/register")
  public ResponseEntity<Object> doRegistration(@RequestBody RegistrationRequest req) {
    return this.userService.registerUser(req); 
}

}
