package Singletontest;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이너")
    public void pureContainer(){
        AppConfig appConfig = new AppConfig();

        //1. 조회 : 호출할때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회 : 호출할때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //3. 참조 값이 다른 것을 확인
        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService1 = " + memberService1);

        //memberservice1 != memberservice2
        assertThat(memberService1).isNotSameAs(memberService2);

    }

    public static void main(String[] args) {
    }
    @Test
    @DisplayName("싱ㄹ글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest(){
        SingletonService singletonService = SingletonService.getInstance();
        SingletonService singletonService1 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService = " + singletonService);
        singletonService1.logic();

        assertThat(singletonService).isSameAs(singletonService1);
    }


    @Test
    public void 스프링컨테이너_싱글톤() throws Exception {
        //given

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService",MemberService.class);

        MemberService memberService2 = ac.getBean("memberService",MemberService.class);

        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService1 = " + memberService1);

        Assertions.assertThat(memberService1).isSameAs(memberService2);



        //when


        //then

    }
}
