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
  
  @PostMapping("user")
  public Principal authenticatedUser(Principal user) {
    return user;
  }

  @PostMapping(path="/register")
  public ResponseEntity<Object> registerUser (@RequestBody RegistrationRequest req) {
    return this.userService.registerUser(req);
  }

  @PostMapping(path="/login")
  public ResponseEntity<Object> loginUser (@RequestBody LoginRequest req) {
    return this.userService.registerUser(req);
  }

  @PostMapping(path="/logout")
  public ResponseEntity<Object> logoutUser (@RequestBody LogoutRequest req) {
    return this.userService.registerUser(req);
  }

  @PostMapping(path="/follow")
  public ResponseEntity<Object> followUser (@RequestBody FollowRequest req) {
    return this.userService.registerUser(req);
  }

  @PostMapping(path="/unfollow")
  public ResponseEntity<Object> unfollowUser (@RequestBody UnfollowRequest req) {
    return this.userService.registerUser(req);
  }
}
