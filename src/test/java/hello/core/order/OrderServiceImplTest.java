package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceImplTest {

    @Test
    public void CreateOrder(){
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L,"name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository,new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "test", 11111);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}