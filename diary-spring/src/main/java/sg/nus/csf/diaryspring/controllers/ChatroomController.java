package sg.nus.csf.diaryspring.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sg.nus.csf.diaryspring.models.CreateChatroomRequest;
import sg.nus.csf.diaryspring.models.InviteChatroomRequest;
import sg.nus.csf.diaryspring.services.ChatroomService;

@RestController
public class ChatroomController {
  
  private ChatroomService chatroomService;

  @Autowired
  public ChatroomController(ChatroomService chatroomService) {
    this.chatroomService = chatroomService;
  }

  public ResponseEntity<Object> createChatroom(@RequestBody CreateChatroomRequest createChatroomRequest) {
    return this.chatroomService.createChatroom(createChatroomRequest);
  }

  public ResponseEntity<Object> inviteToChatroom(@RequestBody InviteChatroomRequest inviteChatroomRequest) {
    return this.chatroomService.inviteToChatroom(inviteChatroomRequest);
  }

}
