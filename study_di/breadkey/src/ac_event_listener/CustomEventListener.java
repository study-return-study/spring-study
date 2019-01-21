package ac_event_listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

public class CustomEventListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            System.out.println("Bean이 초기화 돼었음");
        }
        else if (event instanceof ContextStartedEvent) {
            System.out.println("ApplicationContext가 시작됨");
        }
        else if (event instanceof ContextStoppedEvent) {
            System.out.println("ApplicationContext가 정지됨");
        }
        else if (event instanceof ContextClosedEvent) {
            System.out.println("close 메서드 호출됨");
        }
        else {
            System.out.println("이벤트?");
        }
    }
}
