package com.oriun.oriun.Security.auth.model;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.oriun.oriun.Models.UserModel;


public class UserDetailsImpl implements UserDetails{

    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;


    public UserDetailsImpl( UserModel user ){
        this.username = user.getUSER_NAME();
        this.password = user.getPASSWORD();
        this.authorities=null;
    }

    @Override
    public String getUsername( ){
        return username;
    }

    @Override
    public String getPassword( ){
        return password;
    }



    @Override
    public boolean isAccountNonExpired( ){
        return true;
    }

    @Override
    public boolean isAccountNonLocked( ){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired( ){
        return true;
    }

    @Override
    public boolean isEnabled( ){
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    private Collection<? extends GrantedAuthority> translateRoles(){
        return null;
    }
}
