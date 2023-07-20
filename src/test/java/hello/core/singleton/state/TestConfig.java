package hello.core.singleton.state;

import org.springframework.context.annotation.Bean;

public class TestConfig {

    @Bean
    public StatefulService statefulService() {
        return new StatefulService();
    }

    @Bean
    public StatelessService statelessService() {
        return new StatelessService();
    }

}
