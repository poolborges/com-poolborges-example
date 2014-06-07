package com.poolborges.example.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;  

/**
 *
 * @author Borges
 */
public class Scheduler implements Job {  
  
    //protected static final Log log = LogFactory.getLog(Scheduler.class);  
  
    @Override
    public void execute(JobExecutionContext jobContext)  
        throws JobExecutionException {  
  
        //log.info("entering the quartz config");  
  
        JobDataMap map = jobContext.getJobDetail().getJobDataMap();  
        String username = (String) map.get("username");  
        String password = (String) map.get("password");  
  
        //log.info("mapped data: " + username + "/" + password);  
    }  
  
}