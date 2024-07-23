package org.example.jpa1.repository;

import lombok.Data;
import org.example.jpa1.domain.Address;
import org.example.jpa1.domain.Order;
import org.example.jpa1.domain.OrderStatus;

import java.time.LocalDateTime;

@Data
public class OrderSimpleQueryDto {
    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;

    // dto 생성자에서는 엔티티 그대로 가져와도 됨
    public OrderSimpleQueryDto(Long orderId, String name, LocalDateTime orderDate, OrderStatus orderStatus, Address address) {
        this.orderId = orderId;
        this.name = name;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address;
    }
}