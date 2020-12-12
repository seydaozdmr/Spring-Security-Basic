package com.security.demo.Service;

import com.security.demo.Model.Role;
import com.security.demo.Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorityList;

    public MyUserDetails(User user) {
        //Kullanıcı bilgilerini bu sınıf içinde map ediyorum UserDetails interface'ini impelement ederek.
        String[]userRoles=user.getRoles().stream().map((role)->role.getName()).toArray(String[]::new);
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        this.userName=user.getUserName();
        this.password=user.getPassword();
        this.active=user.isActive();
        this.authorityList= authorities;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return this.authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
        return this.active;
    }
}
