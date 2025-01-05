package spring.oauthsession.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import spring.oauthsession.dto.CustomOAuth2User;
import spring.oauthsession.dto.GoogleResponse;
import spring.oauthsession.dto.NaverResponse;
import spring.oauthsession.dto.OAuth2Response;
import spring.oauthsession.entity.UserEntity;
import spring.oauthsession.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    //DefaultOAuth2UserService OAuth2UserService의 구현체

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println(oAuth2User.getAttributes());

        // 네이버인지 구글인지 판단하는 id
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;
        if (registrationId.equals("naver")) {
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        }
        else if (registrationId.equals("google")) {
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        }
        else {
            return null;
        }

        //받은 정보를 db에 저장
        String username = oAuth2Response.getProvider()+" "+ oAuth2Response.getProviderId();
        UserEntity existData = userRepository.findByUsername(username);

        String role = null;

        //처음 로그인 시
        if (existData == null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(username);
            userEntity.setEmail(oAuth2Response.getEmail());
            userEntity.setRole("ROLE_USER");

            userRepository.save(userEntity);
        } else { // 두번째 로그인 시
            role = existData.getRole();
            existData.setEmail(oAuth2Response.getEmail());
            userRepository.save(existData);
        }

        // Spring Security의 인증(authentication) 컨텍스트에 사용자 정보를 전달
        return new CustomOAuth2User(oAuth2Response, role);
    }
}