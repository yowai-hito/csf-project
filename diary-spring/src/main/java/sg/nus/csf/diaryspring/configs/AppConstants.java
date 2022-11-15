package sg.nus.csf.diaryspring.configs;

public class AppConstants {

  // User SQL Statements
  public static final String SQL_USERS_SELECT_USER_BY_USERNAME = 
  "SELECT * from csf_project.users where account_name = ?";

  public static final String SQL_USERS_CREATE_USER_ACCOUNT = "INSERT INTO csf_project.users(account_name, account_password, account_role, account_handle, account_email) " + 
  "VALUES (?,?,?,?,?)";

  public static final String SQL_USERS_SELECT_USERID_FROM_HANDLE = 
  "SELECT account_id FROM csf_project.users WHERE account_handle IN ";

  // Chatroom SQL Statements
  public static final String SQL_CHATROOM_CREATE_CHATROOM = "INSERT INTO csf_project.CHATROOMS(chatroom_id, chatroom_name)" +
  "VALUES (?, ?)";

  public static final String SQL_CHATROOM_ADD_TO_CHATROOM = "INSERT INTO csf_project.CHATROOM_USERS(chatroom_id, account_id)" +
  "VALUES (?,?)";
}
