package jpabook.jpashop.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.exception.NotEnoughStockException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired EntityManager em;
    @Autowired OrderService orderService;

    @Test
    void 상품주문(){
        Member member = createMember();

        Book book = createBook();

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        Order getOrder = orderService.findOne(orderId);

        assertThat(orderId).isEqualTo(getOrder.getId());
        assertThat(1).isEqualTo(getOrder.getOrderItems().size());
        assertThat(10000 * orderCount).isEqualTo(getOrder.getTotalPrice());
        assertThat(8).isEqualTo(book.getStockQuantity());
    }

    @Test
    void 주문취소(){
        Member member = createMember();
        Book book = createBook();

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        orderService.cancelOrder(orderId);

        Order getOrder = orderService.findOne(orderId);


    }

    @Test
    void 상품주문_재고수량초과(){
        Member member = createMember();
        Book book = createBook();

        int orderCount = 11;

        assertThrows(NotEnoughStockException.class, () ->
            orderService.order(member.getId(), book.getId(), orderCount));
    }

    private Book createBook() {
        Book book = new Book();
        book.setName("시골 JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);
        return book;
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("park");
        member.setAddress(new Address("서울", "한강길", "123123"));
        em.persist(member);
        return member;
    }
}