package org.example.jpa1.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order extends BaseEntity{  // BaseEntity 전체적으로 공통적으로 들어가는 속성

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    // ManyToOne, OneToOne 은 fetch 조인해도 중복이 발생하지 않아 페이징 가능
    // OneToMany, ManyToMany는 페이징 시 중복때문에 fetch조인 불가
    // ex) team 1 member 1, member2 가 있는데
    // select t from Team t join fetch t.members m
    // 그럼 team의 수를 세고 싶은데 team1이 member1, 2를 가지고있어
    // 개수는 1개가 나와야하는데 member1, member2의 team인 team1이 중복이 제거가안되어 team1의 개수가 2개로 나옴
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 연관관계 주인
    private Member member;

    @BatchSize(size = 100) // 디테일하게 적용 - 컬렉션일때
    //caseCade 하면 Item 각각 persist안하고 Order만 perist 해서 저장 원래는 Item을 각각 persist해줘야함
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    // casecade order 저장할때 연관관계된 것들도 한번에 저장하겠다. 따로 안하고
    // 소유자가 하나일 때만 casecase사용 다른 곳에서도 사용하면 casecade 절대 안됨!! 단일종속때만 사용
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; // 주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문상태 [ORDER, CANCEL]

    // == 생성 메서드 ==//

    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    // == 비지니스 로직 == //
    /**
     * 주문 취소
     */
    public void cancel() {
        if (delivery.getStatus() == DeliveryStatus.COMP) {
            throw new IllegalStateException("이미 배송된 상품은 취소가 불가");
        }

        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }

    //==조회 로직==//
    /**
     * 전체 주문 가격 조회
     */

    public int getTotalPrice(){
        int totalPrice = orderItems.stream().mapToInt(OrderItem::getTotalPrice).sum();

        // 동일한 로직
//        int totalPrice = 0;
//        for (OrderItem orderItem : orderItems) {
//            totalPrice += orderItem.getTotalPrice();
//        }
//
//        return totalPrice;
        return totalPrice;
    }

    // == 연관관계 메서드 ==//
    // 위치 JoinColumn 있는 곳
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
