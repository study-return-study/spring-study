package di_bean.property_file;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageRun {
    public static void main(String[] args) {
        BeanFactory context = new ClassPathXmlApplicationContext("/di_bean/property_file/config/applicationContext.xml");
        MessageService messageService = context.getBean(MessageService.class);

        System.out.println(messageService.getMessage());
    }
}
