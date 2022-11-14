package sg.nus.csf.diaryspring.configs;

public class AppConstants {

  // User SQL Statements
  public static final String SQL_USERS_SELECT_USER_BY_USERNAME = 
  "SELECT * from users where account_name = ?";

  public static final String SQL_USERS_CREATE_USER_ACCOUNT = "INSERT INTO users(account_name, account_password, account_type, account_handle) " + 
  "VALUES (?,?,?,?)";

  public static final String SQL_USERS_SELECT_USERID_FROM_HANDLE = 
  "SELECT account_id FROM users WHERE account_handle IN ";

  // Chatroom SQL Statements
  public static final String SQL_CHATROOM_CREATE_CHATROOM = "INSERT INTO CHATROOMS(chatroom_id, chatroom_name)" +
  "VALUES (?, ?)";

  public static final String SQL_CHATROOM_ADD_TO_CHATROOM = "INSERT INTO CHATROOM_USERS(chatroom_id, account_id)" +
  "VALUES (?,?)";
}
