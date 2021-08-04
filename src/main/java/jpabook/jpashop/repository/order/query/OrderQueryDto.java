package jpabook.jpashop.repository.order.query;

import java.time.LocalDateTime;
import java.util.List;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.OrderStatus;
import lombok.Data;

/**
 * Project : jpashop
 * Created by gonuu
 * Date : 2021-08-04
 * Time : 오전 9:57
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

@Data
public class OrderQueryDto {
    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;
    private List<OrderItemQueryDto> orderItems;

    public OrderQueryDto(Long orderId, String name, LocalDateTime orderDate,
        OrderStatus orderStatus, Address address
        ) {
        this.orderId = orderId;
        this.name = name;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address;
        //this.orderItems = orderItems;
    }
}
