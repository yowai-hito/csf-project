package sg.nus.csf.diaryspring.configs;

public class AppConstants {

  public static final String SQL_USERS_SELECT_USER_BY_USERNAME = 
  "SELECT * from users where account_name = ?";

  public static final String SQL_USERS_CREATE_USER_ACCOUNT = "INSERT INTO USERS(account_name, account_password, account_type, account_handle) " + 
  "VALUES (?,?,?,?)";

}
