package com.poolborges.example.springscheduler;

import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * @author PauloBorges
 */
public class DemoScheduler {

    @Scheduled(fixedRate = 5000)
    public void doSomething() {
        System.out.println("ScheduerFixed");
    }

    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void doSomethingDelay() {
        System.out.println("ScheduerDelay");
    }

    @Scheduled(cron = "*/5 * * * * MON-FRI")
    public void doSomethingCron() {
        System.out.println("ScheduerCron");
    }
    //private static final Logger logger = Logger.getLogger(DataHarvestingServiceImpl.class);
    private static int count = 0;

//@Override
// Every night at 1 AM
// @Scheduled(cron = "* * 1 * * ?")
    @Scheduled(cron = "0 * * * * ?")
    public void collectSocialMediaData() {
        //logger.info("Starting data retrieval at " + new Date(System.currentTimeMillis()));
        //logger.info("Finished media data retrieval at " + new Date(System.currentTimeMillis()));
        System.out.println("count is " + count++);
    }

}
