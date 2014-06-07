package javadigest.spring.scheduler;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class YourScheduler {
   
    @Scheduled(fixedRate = 5000)
    public void process() {
        System.out.println("YourScheduler process at " + new Date());
    }
 
}
