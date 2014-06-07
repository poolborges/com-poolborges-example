package javadigest.spring.scheduler;

import java.util.Date;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification {

    @Async
    public void execute() {
        System.out.println("EmailNotification process at " + new Date());
    }
}