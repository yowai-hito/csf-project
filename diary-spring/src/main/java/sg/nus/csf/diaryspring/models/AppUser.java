package sg.nus.csf.diaryspring.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AppUser implements UserDetails {

  private final List<? extends GrantedAuthority> grantedAuthorities;
  private final String handle;
  private final String username;
  private final String password;
  private final String email;
  private final boolean isAccountNonExpired;
  private final boolean isAccountNonLocked;
  private final boolean isCredentialsNonExpired;
  private final boolean isEnabled;

  public AppUser(String username, String password, String handle, String email) {
    List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
    roles.add(new SimpleGrantedAuthority("ROLE_USER"));
    this.username = username;
    this.password = password;
    this.handle = handle;
    this.email = email;
    this.grantedAuthorities = roles;
    this.isAccountNonExpired = true;
    this.isAccountNonLocked = true;
    this.isCredentialsNonExpired = true;
    this.isEnabled = true;
  }

  public AppUser(List<? extends GrantedAuthority> grantedAuthorities, String username, String password, String handle, String email) {
    this.grantedAuthorities = grantedAuthorities;
    this.username = username;
    this.password = password;
    this.handle = handle;
    this.email = email;
    this.isAccountNonExpired = true;
    this.isAccountNonLocked = true;
    this.isCredentialsNonExpired = true;
    this.isEnabled = true;
  }

  public AppUser(List<? extends GrantedAuthority> grantedAuthorities, String username, String password, String handle, String email,
      boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled) {
    this.grantedAuthorities = grantedAuthorities;
    this.username = username;
    this.password = password;
    this.handle = handle;
    this.email = email;
    this.isAccountNonExpired = isAccountNonExpired;
    this.isAccountNonLocked = isAccountNonLocked;
    this.isCredentialsNonExpired = isCredentialsNonExpired;
    this.isEnabled = isEnabled;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return grantedAuthorities;
  }

  @Override
  public String getPassword() {
    // TODO Auto-generated method stub
    return password;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    return username;
  }

  public String getHandle() {
    return handle;
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return isAccountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return isAccountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return isCredentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return isEnabled;
  }

  
}
