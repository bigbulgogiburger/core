package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class RateDIscountPoilcyTest {

    RateDiscountPolicy discountPoilcy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    public void vip_0(){
        //given
        Member memberVip = new Member(1L, "memberVip", Grade.VIP);
        //when

        int discount = discountPoilcy.discount(memberVip, 10000);


        //then

        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("vip가 아니면 할인이 적용되지 않아야 한다.")
    public void vip_x(){
        //given
        Member memberVip = new Member(2L, "memberVip", Grade.BASIC);
        //when

        int discount = discountPoilcy.discount(memberVip, 10000);


        //then

        Assertions.assertThat(discount).isEqualTo(0);
    }

}