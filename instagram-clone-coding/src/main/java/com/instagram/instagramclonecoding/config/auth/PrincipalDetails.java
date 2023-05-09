package com.instagram.instagramclonecoding.config.auth;

import com.instagram.instagramclonecoding.domain.user.User;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Data
public class PrincipalDetails implements UserDetails {

    private static final long serialVersionUID = 1L;
    private User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //권한을 가져옴
        //권한이 한개가 아닐 수도 있음(3개 이상의 권한 일수도)

        Collection<GrantedAuthority> colllector = new ArrayList<>();
        colllector.add(() -> {
            return user.getRole();
        });
        return colllector;
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
}
