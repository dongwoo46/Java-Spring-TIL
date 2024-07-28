package spring.actuator.order.v2;

import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.actuator.order.OrderService;

@Configuration
public class OrderConfigV2 {

    @Bean
    public OrderService orderService() {

        return new OrderServiceV2();
    }

    @Bean
    public CountedAspect countedAspect(MeterRegistry registry) {
        //CountedAspect가 빈으로 등록되지 않으면 @Counted AOP 동작 x
        return new CountedAspect(registry);

    }


}
