package com.nt.jai.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListener implements JobExecutionListener {
	private static final Logger LOG = LoggerFactory.getLogger(MyJobListener.class);

	@Override
	public void beforeJob(JobExecution jobExecution) {
		LOG.info("BEFORE STARTING JOB {},{}",jobExecution.getStatus(),jobExecution.getStartTime());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		LOG.info("AFTER FINISHING JOB {},{}",jobExecution.getStatus(),jobExecution.getEndTime());

	}

}
