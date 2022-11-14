package sg.nus.csf.diaryspring.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AppUserRole {
  
  private final static String userRole = "ROLE_USER";
  private final static String managerRole = "ROLE_MANAGER";
  
  public static List<GrantedAuthority> getRole(String role){

    List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

    if (role.equals("USER")){
      roles.add(new SimpleGrantedAuthority(userRole));
    }

    else if (role.equals("MANAGER")){
      roles.add(new SimpleGrantedAuthority(managerRole));
    }

    return roles;
  }

}
