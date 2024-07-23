package org.example.jpa1.domain;

import jakarta.persistence.*;
import lombok.Data;

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

    private String name;

    @Embedded
    private Address address;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column("WORK_CITY")), @AttributeOverride(name = "street", column = @Column("WORK_STREET")), @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))
//    })
//    private Address workAddress;

    @OneToMany(mappedBy = "member") // Orders의 member와 연결
    private List<Order> orders = new ArrayList<>();


}
