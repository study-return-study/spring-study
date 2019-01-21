package ac_event_listener.config;

import ac_event_listener.CustomEventListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ApplicationListener applicationListener() {
        return new CustomEventListener();
    }
}
