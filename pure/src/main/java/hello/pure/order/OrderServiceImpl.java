package hello.pure.order;

import hello.pure.discount.DiscountPolicy;
import hello.pure.discount.FixDiscountPolicy;
import hello.pure.discount.RateDiscountPolicy;
import hello.pure.member.Member;
import hello.pure.member.MemberRepository;
import hello.pure.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
