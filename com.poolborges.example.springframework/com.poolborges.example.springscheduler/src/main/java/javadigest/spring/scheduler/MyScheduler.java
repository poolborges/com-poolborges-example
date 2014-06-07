package javadigest.spring.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

    @Autowired
    private Notification task;

    //The time period in milliseconds.
    //@Scheduled(cron="0 0 * * * *")
    //@Scheduled(fixedRate=5000)
    @Scheduled(fixedDelay = 5000)
    public void processScheduledJob() {
        task.execute();
    }

    public Notification getTask() {
        return task;
    }

    public void setTask(Notification task) {
        this.task = task;
    }
}