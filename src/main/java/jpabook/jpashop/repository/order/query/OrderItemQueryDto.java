package jpabook.jpashop.repository.order.query;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Project : jpashop
 * Created by gonuu
 * Date : 2021-08-04
 * Time : 오전 10:00
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

@Data
public class OrderItemQueryDto {

    @JsonIgnore
    private Long orderId;
    private String itemName;
    private int orderPrice;
    private int count;

    public OrderItemQueryDto(Long orderId, String itemName, int orderPrice, int count) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.orderPrice = orderPrice;
        this.count = count;
    }
}
