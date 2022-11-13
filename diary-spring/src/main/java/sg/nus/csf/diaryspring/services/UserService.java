package sg.nus.csf.diaryspring.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sg.nus.csf.diaryspring.models.RegistrationRequest;

@Service
public class UserService {
  
  public ResponseEntity<Object> registerUser (RegistrationRequest req) {
    Object responseBody = new Object();
    HttpHeaders responseHeaders = new HttpHeaders();
    HttpStatus responseStatus = HttpStatus.resolve(200);

    responseHeaders.set("Content-Type","application/json");
    responseHeaders.set("Accept", "application/json");
    
    return new ResponseEntity<>(responseBody, responseHeaders, responseStatus);
  }

  public ResponseEntity<Object> loginUser (LoginRequest req) {

  }

  public ResponseEntity<Object> logoutUser (LogoutRequest req) {
    
  }

  public ResponseEntity<Object> followUser (FollowRequest req) {

  }

  public ResponseEntity<Object> unfollowUser (UnfollowRequest req) {

  }

}
