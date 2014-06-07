/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.quartz;


import org.quartz.*;
import org.slf4j.*;

/**
 *
 * @author Borges
 */
public class MyJob implements Job {

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    try {
      // Do all my stuff here
      //logger.info("HelloJob executed");
        System.out.println("PBORGES - QUARTz TESTE");
    } catch (Exception ex) {
      LoggerFactory.getLogger(getClass()).error(ex.getMessage());
    }
  }
}
