package com.oriun.oriun.Security.auth.service;



import com.oriun.oriun.Models.UserModel;
import com.oriun.oriun.Security.auth.model.UserDetailsImpl;
import com.oriun.oriun.Services.UserService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service( "userDetailsService" )
public class UserDetailsServiceImpl implements UserDetailsService{

    private UserService userService;

    public UserDetailsServiceImpl( UserService userService ){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername( String username ){
        UserModel user = userService.getUser(username).get();
        if( user == null ){
            throw new UsernameNotFoundException( "" );
        }
        return new UserDetailsImpl( user );
    }

}