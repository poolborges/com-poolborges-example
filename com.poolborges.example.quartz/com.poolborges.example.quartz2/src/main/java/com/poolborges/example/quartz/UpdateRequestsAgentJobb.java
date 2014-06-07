/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.quartz;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
 
/**
 *
 * @author Borges
 */
 public class UpdateRequestsAgentJobb implements Job{
 
 	@Override
 	public void execute(JobExecutionContext arg0) throws JobExecutionException {
 		//RequestsLogger.finest("UpdateRequestsAgentJobb:execute(JobExecutionContext arg0), Quartz Starting Job ");
 		
 		//UpdateRequests updateRequests = new UpdateRequests();
 		//updateRequests.startUpdateRequest();
 		
 		// updateRequests = null;
 	}
 }