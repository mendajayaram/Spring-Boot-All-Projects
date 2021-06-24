package com.nt.jai.listner;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyListener  implements JobExecutionListener{

	@Override
	public void beforeJob(JobExecution jobExecution) {
	System.out.println("Starting :"+jobExecution.getStatus());
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("Ending :"+jobExecution.getStatus());
		
	}

}
