package org.example.jpa1.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.jpa1.domain.Address;
import org.example.jpa1.domain.Order;
import org.example.jpa1.domain.OrderStatus;
import org.example.jpa1.repository.OrderRepository;
import org.example.jpa1.repository.OrderSearch;
import org.example.jpa1.repository.OrderSimpleQueryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * XToOne ( ManyToOne, OneToOne)
 * Order
 * Order => Member
 * Order => Delivery
 */

@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderRepository orderRepository;

    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        return all;
    }

    // dto 활용 N+1 문제 발생
    @GetMapping("/api/v2/simple-orders")
    public List<SimpleOrderDto> ordersV2() {
        // order 2개
        // N + 1 문제 -> 1 + 회원 N + 배송 N
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());

        List<SimpleOrderDto> result = orders.stream()
                .map(o-> new SimpleOrderDto(o))
                .collect(Collectors.toList());

        return result;
    }

    //fetch join 활용해서 한번에 모든 값 가져오기 지연로딩 발생 x
    @GetMapping("/api/v3/simple-orders")
    public List<SimpleOrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithMemberDelivery();

        List<SimpleOrderDto> result = orders.stream()
                .map(o -> new SimpleOrderDto(o))
                .collect(Collectors.toList());

        return result;
    }

    @GetMapping("/api/v4/simple-orders")
    public List<OrderSimpleQueryDto> ordersV4() {
        return orderRepository.findOrderDtos();
    }

    @Data
    static class SimpleOrderDto {
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;

        // dto 생성자에서는 엔티티 그대로 가져와도 됨
        public SimpleOrderDto(Order order) {
            orderId = order.getId();
            name = order.getMember().getName();
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getDelivery().getAddress();
        }
    }
}
