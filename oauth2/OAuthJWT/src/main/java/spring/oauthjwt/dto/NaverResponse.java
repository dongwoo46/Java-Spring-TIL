package spring.oauthjwt.dto;

import lombok.RequiredArgsConstructor;

import java.util.Map;

public class NaverResponse implements OAuth2Response{

    private final Map<String, Object> attribute;

    public NaverResponse(Map<String, Object> attribute) {
        // 캐스팅을 이용해 객체 타입을 map으로 바꿔서 집어넣어줌
        this.attribute = (Map<String, Object>) attribute.get("response");
    }

    @Override
    public String getProvider() {

        return "naver";
    }

    @Override
    public String getProviderId() {

        return attribute.get("id").toString();
    }

    @Override
    public String getEmail() {
        Object email = attribute.get("email");
        return (email != null) ? email.toString() : "sniper";
    }

    @Override
    public String getName() {

        return attribute.get("name").toString();
    }
}