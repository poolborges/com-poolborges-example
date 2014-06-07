/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.quartz;

import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;
/**
 *
 * @author Borges
 */
public class DeltaMailAgentsTrigger {
    Scheduler scheduler = null;
     public boolean startAgentJobbs() {
 
         try {
             // Grab the Scheduler instance from the Factory 
             scheduler = StdSchedulerFactory.getDefaultScheduler();
 
             // and start it off
             scheduler.start();
 
             // define the job and tie it to our HelloJob class
             JobDetail EmailToRequestAgentJobb = newJob(EmailToRequestAgentJobb.class)
                 .withIdentity("EmailToRequestAgentJobb", "DeltaDirekteAgenter")
                 .build();
 
             JobDetail UpdateRequestsAgentJobb = newJob(UpdateRequestsAgentJobb.class)
             .withIdentity("UpdateRequestsAgentJobb", "DeltaDirekteAgenter")
             .build();
 
             // Trigger the job to run now, and then repeat every 40 seconds
             Trigger EmailToRequestAgentTrigger = newTrigger()
                 .withIdentity("EmailToRequestAgentTrigger", "DeltaDirekteAgenter")
                 .startNow()
                 .withSchedule(simpleSchedule()
                         .withIntervalInMinutes(5)
                         .repeatForever())            
                 .build();
  
             Trigger UpdateRequestsAgentJobbTrigger = newTrigger()
             .withIdentity("UpdateRequestsAgentJobbTrigger", "DeltaDirekteAgenter")
             .startNow()
             .withSchedule(simpleSchedule()
             		.withIntervalInMinutes(5)
             		.repeatForever())            
             		.build();
 
             // Tell quartz to schedule the job using our trigger
             scheduler.scheduleJob(EmailToRequestAgentJobb, EmailToRequestAgentTrigger);
             scheduler.scheduleJob(UpdateRequestsAgentJobb, UpdateRequestsAgentJobbTrigger);
             return true;
 
         } catch (SchedulerException se) {
             se.printStackTrace();
             return false;
         }
     }
     
     public void stopAgentJobbs() {
         try {
 			scheduler.shutdown();
 		} catch (SchedulerException e) {
 			e.printStackTrace();
 		}
 
     }
 
}
