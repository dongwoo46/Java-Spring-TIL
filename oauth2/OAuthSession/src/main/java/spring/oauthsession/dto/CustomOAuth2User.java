package spring.oauthsession.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@RequiredArgsConstructor
public class CustomOAuth2User implements OAuth2User {

    private final OAuth2Response oAuth2Response;
    private final String role;

    // 로그인 진행시 로그인 서버로 부터 보내지는 모든 데이터 값들
    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add((new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return role;
            }
        }));
        return null;
    }

    @Override
    public String getName() {
        return oAuth2Response.getName();
    }

    // username 이란건 없기 때문에 스스로 만듬
    public String getUsername() {
        return oAuth2Response.getProvider()+" "+oAuth2Response.getProvider();
    }
}
