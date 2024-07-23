package org.example.jpa1.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;

import java.util.Objects;

// 값타입은 실제 인스턴스 값을 공유하는것 위함  대신 인스턴스 복사해 사용
@Embeddable // 내장 타입 , 값타입
// 왜 Getter만 만들고  Setter가 없는지?
// 값 타입은 불변객체로 설계해야함 왜냐하면 setter가 있으면 복사가 아니라 참조값을 가르켜
// 다른 모든 값이 다 바뀌기 때문에 새로운 객체를 만들기 위해 Setter없이
// getter만 만든것 값바꿔서 모든 참조값이 바뀌는 것을 막기위해
// 즉 생성자로만 값을 설정하고 수정자 만들지 않기! setter없이 constructor만!
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;



    protected Address() {
    }
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    // 값타입은 동등성 비교를 위해 equals 오버라이딩
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(zipcode, address.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }
}
