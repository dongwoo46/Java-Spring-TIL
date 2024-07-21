package org.example.testsecurity.dto;

import org.example.testsecurity.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private UserEntity userEntity;

    public CustomUserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    // 사용자 특정 권한 넣어주기
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add((new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return userEntity.getRole();
            }
        }));
        return collection;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    // 아래 4개는 entity만들때 넣어주지 않았기 때문에 return true로 강제 입력
    @Override
    public boolean isAccountNonExpired() { // 만료되었는가
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //아이디가 잠겨있는가
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 사용가능한 아이디인가
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
