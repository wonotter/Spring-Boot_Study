package hello.puretospring.discount;

import hello.puretospring.member.Grade;
import hello.puretospring.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {
    
    private int discountPercent = 10; // 10% 할인
    
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
