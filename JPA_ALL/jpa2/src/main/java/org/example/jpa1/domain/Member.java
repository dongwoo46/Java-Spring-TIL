package org.example.jpa1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;

    @Embedded
    private Address address;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column("WORK_CITY")), @AttributeOverride(name = "street", column = @Column("WORK_STREET")), @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))
//    })
//    private Address workAddress;

//    @JsonIgnore -> 해당 정보 직렬화에서 제외
    @JsonIgnore
    @OneToMany(mappedBy = "member") // Orders의 member와 연결
    private List<Order> orders = new ArrayList<>();


}
