package com.demo.security;

import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserDetailsServiceImpl.loadUserByUsername");

        //User user = userRepository.findOneByUsername(username); //username and enable
        User user = userRepository.findOneByUsernameAndStatus(username, 1);
        //username and enable

        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("Username not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role: user.getRoles()) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.getName());
            authorities.add(authority);
        }

        UserDetailsImpl userDetails = new UserDetailsImpl(user.getUsername(),
                user.getPassword(), user.getFullName(),
                user.getActive(), user.getRoles(), authorities);
        BeanUtils.copyProperties(user, userDetails);
        return userDetails;
    }

}
