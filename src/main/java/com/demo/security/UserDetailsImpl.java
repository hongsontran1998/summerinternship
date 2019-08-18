package com.demo.security;

import com.demo.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    //hoặc extends org.springframework.security.core.userdetails.User;
    private static final long serialVersionUID = 1L;

    private String userName;
    private String password;
    private String fullName;
    private Integer active;
    private List<Role> roles;
    private List<GrantedAuthority> authorities;

    public UserDetailsImpl(String userName, String password, String fullName,
                           Integer active, List<Role> roles, List<GrantedAuthority> authorities) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.active = active;
        this.roles = roles;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getActive() {
        return active;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }



}
