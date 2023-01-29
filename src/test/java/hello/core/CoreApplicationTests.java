package hello.core;

import hello.core.discount.DiscountPolicy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {

	@Autowired
	DiscountPolicy discountPolicy;

	@Test
	void contextLoads() {
//		discountPolicy.discount(11);
	}

}
