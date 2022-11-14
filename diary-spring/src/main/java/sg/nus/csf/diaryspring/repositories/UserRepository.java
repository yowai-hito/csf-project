package sg.nus.csf.diaryspring.repositories;

import java.sql.ResultSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.nus.csf.diaryspring.models.AppUser;
import sg.nus.csf.diaryspring.models.AppUserRole;

import static sg.nus.csf.diaryspring.configs.AppConstants.*;

@Repository
public class UserRepository {
  @Autowired
  JdbcTemplate jdbc;

  public Optional<AppUser> selectAppUserByUsername(String username) {
    
    return jdbc.query(SQL_USERS_SELECT_USER_BY_USERNAME, 
    (ResultSet rs) -> {
        if (!rs.next()){return Optional.empty();}
        AppUser user = new AppUser(
          AppUserRole.getRole(rs.getString("account_role")),
          rs.getString("account_name"),
          rs.getString("account_password"),
          rs.getString("account_handle")
        );
        return Optional.of(user);
    },
    username);
  }
  
  public int registerUser(AppUser user) {

    return jdbc.update(SQL_USERS_CREATE_USER_ACCOUNT,
      user.getUsername(), user.getPassword(), user.getAuthorities(), user.getHandle());
  } 
}
