package hello.pure;

import hello.pure.member.Grade;
import hello.pure.member.Member;
import hello.pure.member.MemberService;
import hello.pure.member.MemberServiceImpl;
import hello.pure.order.Order;
import hello.pure.order.OrderService;
import hello.pure.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
    }
}
