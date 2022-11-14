package sg.nus.csf.diaryspring.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static sg.nus.csf.diaryspring.configs.AppConstants.*;

import java.util.UUID;

@Repository
public class ChatroomRepository {
  
  @Autowired
  JdbcTemplate jdbc;

  public int createChatroom(byte[] byteUuid, String chatroomName){
    return jdbc.update(SQL_CHATROOM_CREATE_CHATROOM, byteUuid, chatroomName);
  }

  public int inviteToChatroom (byte[] chatroomId, int accountId){
    return jdbc.update(SQL_CHATROOM_ADD_TO_CHATROOM, chatroomId, accountId);
  }
}
