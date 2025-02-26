package hello.puretospring;

import hello.puretospring.discount.DiscountPolicy;
import hello.puretospring.discount.RateDiscountPolicy;
import hello.puretospring.member.MemberRepository;
import hello.puretospring.member.MemberService;
import hello.puretospring.member.MemberServiceImpl;
import hello.puretospring.member.MemoryMemberRepository;
import hello.puretospring.order.OrderService;
import hello.puretospring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
