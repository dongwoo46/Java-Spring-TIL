package org.example.jpa1.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.jpa1.domain.Address;
import org.example.jpa1.domain.Order;
import org.example.jpa1.domain.OrderItem;
import org.example.jpa1.domain.OrderStatus;
import org.example.jpa1.repository.OrderRepository;
import org.example.jpa1.repository.OrderSearch;
import org.example.jpa1.repository.order.query.OrderFlatDto;
import org.example.jpa1.repository.order.query.OrderQueryDto;
import org.example.jpa1.repository.order.query.OrderQueryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class OrderApiController {
    private final OrderRepository orderRepository;
    private final OrderQueryRepository orderQueryRepository;

    @GetMapping("/api/v1/orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAllByString(new OrderSearch());

        for (Order order : all) {
            order.getMember().getName();
            order.getDelivery().getAddress();
            List<OrderItem> orderItems = order.getOrderItems();
            orderItems.stream().forEach(o -> o.getItem().getName());

        }
        return all;
    }

    @GetMapping("/api/v2/orders")
    public List<OrderDto> ordersV2() {
        return orderRepository.findAllByString(new OrderSearch()).stream()
                .map(OrderDto::new)
                .collect(toList());

        /**
         * List<Order> orders = orderRepository.findAllByString(new OrderSearch());
         * List<OrderDto> result = orders.stream()
         * .map(o -> new OrderDto(o))
         * .collect(toList());
         * return result;
         */
    }

    // 페치 조인 사용 -> 페치조인으로 페이징 불가 (setMaxResults, setFirstResult)
    // 컬렉션 페치조인(일대다 페치조인)은 1개만 가능 둘 이상에서는 데이터 부정합하게 될 수 잇음
    // 컬렉션 페치조인 시 페이징은 불가능!!!!! 잘못하면 메모리 아웃!
    @GetMapping("/api/v3/orders")
    public List<OrderDto> ordersV3() {
        // distinct 이용해서 중복 제거
        List<Order> orders = orderRepository.findAllWithItem();
        List<OrderDto> result = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(toList());
        return result;
    }

    /**
     * XToOne -> 페치조인
     * XToMany -> 페치조인 x, 지연로딩 그대로 사용, batchsize활용
     */
    @GetMapping("/api/v3.1/orders")
    public List<OrderDto> ordersV3_page(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                        @RequestParam(value = "limit", defaultValue = "100")int limit) {
        // fetch 조인으로 XToOne만 가져오기
        List<Order> orders = orderRepository.findAllWithMemberDelivery2(offset, limit);
        List<OrderDto> result = orders.stream()
                .map(o -> new OrderDto(o)) // orderItems 컬렉션 조회
                .collect(toList());
        return result;
    }

    @GetMapping("/api/v4/orders")
    public List<OrderQueryDto> ordersV4() {
        return orderQueryRepository.findOrderQueryDtos();
    }

    @GetMapping("/api/v5/orders")
    public List<OrderQueryDto> ordersV5() {
        return orderQueryRepository.findAllByDto_optimization();
    }

    @GetMapping("/api/v6/orders")
    public List<OrderQueryDto> ordersV6() {
        List<OrderFlatDto> flats = orderQueryRepository.findAllByDto_flat();

        return flats.stream()
                .collect(groupingBy(o -> new OrderQueryDto(o.getOrderId(),
                                o.getName(), o.getOrderDate(), o.getOrderStatus(), o.getAddress()),
                        mapping(o -> new OrderItemQueryDto(o.getOrderId(),
                                o.getItemName(), o.getOrderPrice(), o.getCount()), toList())
                )).entrySet().stream()
                .map(e -> new OrderQueryDto(e.getKey().getOrderId(),
                        e.getKey().getName(), e.getKey().getOrderDate(), e.getKey().getOrderStatus(),
                        e.getKey().getAddress(), e.getValue()))
                .collect(toList());
    }


    @Data
    static class OrderDto {
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;
        private List<OrderItemDto> orderItems;

        public OrderDto(Order order) {
            orderId = order.getId();
            name = order.getMember().getName();
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getDelivery().getAddress();
            orderItems = order.getOrderItems().stream()
                    .map(orderItem -> new OrderItemDto(orderItem))
                    .collect(toList());

        }
    }

    @Data
    static class OrderItemDto {
        private String itemName;
        private int orderPrice;
        private int count;

        public OrderItemDto(OrderItem orderItem) {
            itemName = orderItem.getItem().getName();
            orderPrice = orderItem.getOrderPrice();
            count = orderItem.getCount();
        }
    }
}
