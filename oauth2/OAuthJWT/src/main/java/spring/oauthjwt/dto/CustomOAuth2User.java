package spring.oauthjwt.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@RequiredArgsConstructor
public class CustomOAuth2User implements OAuth2User {
    private final UserDTO userDTO;

    // 구글과 naver에서 보내주는 데이터 값이 너무 달라서 사용X
    // getAttributes는 리소스 서버에서 보내주는 모든 값을 오버라이딩 하는 것
    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    // Role 값을 리턴 해주는데 컬렉션 형태로 리턴해줘야함
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return userDTO.getRole();
            }
        });
        return collection;
    }

    @Override
    public String getName() {

        return userDTO.getName();
    }

    public String getUsername() {

        return userDTO.getUsername();
    }
}
