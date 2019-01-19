package ac_event_listener;

import ac_event_listener.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventListenerRun {
    public static void main(String[] args) {
        EventListenerRun run = new EventListenerRun();
        run.execute();
    }

    public void execute() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ((AnnotationConfigApplicationContext) context).start();
        ((AnnotationConfigApplicationContext) context).stop();
        ((AnnotationConfigApplicationContext) context).close();
    }
}
