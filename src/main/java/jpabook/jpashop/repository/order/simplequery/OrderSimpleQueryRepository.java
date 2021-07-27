package jpabook.jpashop.repository.order.simplequery;

import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Project : jpashop
 * Created by gonuu
 * Date : 2021-07-27
 * Time : 오후 8:30
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;
    public List<SimpleOrderQueryDto> findOrderDto() {
        return em.createQuery(
            "select new jpabook.jpashop.repository.order.simplequery.SimpleOrderQueryDto(o.id, m.name, o.orderDate, o.status, d.address) from Order o "
                + "join o.member m  "
                + "join o.delivery d", SimpleOrderQueryDto.class
        ).getResultList();
    }
}
