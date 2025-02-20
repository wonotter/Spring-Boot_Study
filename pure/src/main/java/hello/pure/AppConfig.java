package hello.pure;

import hello.pure.discount.DiscountPolicy;
import hello.pure.discount.FixDiscountPolicy;
import hello.pure.discount.RateDiscountPolicy;
import hello.pure.member.MemberRepository;
import hello.pure.member.MemberService;
import hello.pure.member.MemberServiceImpl;
import hello.pure.member.MemoryMemberRepository;
import hello.pure.order.OrderService;
import hello.pure.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
