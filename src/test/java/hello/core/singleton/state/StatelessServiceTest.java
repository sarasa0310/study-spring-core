package hello.core.singleton.state;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class StatelessServiceTest {

    @Test
    @DisplayName("stateless하게 변경한 싱글톤 방식")
    void statelessSingletonService() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatelessService statelessService1 = ac.getBean(StatelessService.class);
        StatelessService statelessService2 = ac.getBean(StatelessService.class);

        int price1 = statelessService1.order("userA", 10000);
        int price2 = statelessService2.order("userB", 20000);

        assertThat(price1).isEqualTo(10000);
        assertThat(price2).isEqualTo(20000);
    }

}