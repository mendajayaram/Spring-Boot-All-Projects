package com.nt.jai.runner;

import org.springframework.batch.core.Job;


import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
@Autowired
	private JobLauncher launcher;
@Autowired
	private Job jobA;

	public void run(String... args) throws Exception {
		launcher.run(jobA, new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters());
		System.out.println("DONE");
	}
}
