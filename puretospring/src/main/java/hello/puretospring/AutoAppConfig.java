package hello.puretospring;

import hello.puretospring.member.MemberRepository;
import hello.puretospring.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.puretospring",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    // 자동으로 overriding 되지만 최근 스프링부트는 이에 대해 오류가 발생하도록 막아놓음
//    // 수동 빈과 자동 빈이 섞이면 나중에 잡기 어려운 버그가 만들어지기 때문
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memoryMemberRepository() {
//        return new MemoryMemberRepository();
//    }

}
