package com.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsUtil {
    //static để dùng bên jsp
    public static UserDetailsImpl getUserDetails() throws Exception {
        return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static List<String> getAuthorities() {
        List<String> results = new ArrayList<>();
        List<GrantedAuthority> authorities =
                (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
        return results;
    }
}
