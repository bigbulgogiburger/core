package findbean;

import hello.core.AppConfig;
import hello.core.member.MemberSerivceImpl;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberSerivceImpl.class);

    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    public void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberSerivceImpl.class);

    }

    @Test
    @DisplayName("구체 타입으로 조회")
    public void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberSerivceImpl.class);
        assertThat(memberService).isInstanceOf(MemberSerivceImpl.class);
    }


    @Test
    @DisplayName("구체 타입으로 조회")
    public void findBeanByNameX(){
//        MemberService memberService = ac.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxx", MemberService.class));
    }




}
