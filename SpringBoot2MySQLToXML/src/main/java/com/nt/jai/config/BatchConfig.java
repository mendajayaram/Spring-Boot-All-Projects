package com.nt.jai.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.nt.jai.model.User;

public class BatchConfig {
	@Autowired
	private DataSource dataSource;

	@Bean
	public ItemReader<User> reader() {
		JdbcCursorItemReader<User> reader = new JdbcCursorItemReader<>();
		reader.setDataSource(dataSource);
		reader.setSql("\"SELECT UID, UNAME, UROLE, UDEPT FROM USERTAB");
		reader.setRowMapper((rs, n) -> new User(rs.getInt("uid"), rs.getString("uname"), rs.getString("urole"),
				rs.getString("udept")));
		return reader;
	}

	@Bean
	public ItemProcessor<User, User> processor() {
		return item -> item;
		// return new UserProcessor();
	}

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(User.class);
		return marshaller;
	}

	@Bean
	public ItemWriter<User> writer() {
		// StAX = Streaming API for XML (JAXB)
		StaxEventItemWriter<User> writer = new StaxEventItemWriter<>();
		// XML file location
		writer.setResource(new FileSystemResource("E:/myouts/usersdata.xml"));
		writer.setMarshaller(marshaller());
		writer.setRootTagName("users");
		return writer;
	}

	@Bean
	public JobExecutionListener listener() {
		// return new MyJobListener();
		return new JobExecutionListener() {
			public void beforeJob(JobExecution je) {
				System.out.println("Starting : " + je.getStatus());
			}

			public void afterJob(JobExecution je) {
				System.out.println("Ending : " + je.getStatus());
			}
		};
	}

	@Autowired
	private StepBuilderFactory sf;

	@Bean
	public Step stepA() {
		return sf.get("stepA").<User, User>chunk(3).reader(reader()).processor(processor()).writer(writer()).build();
	}

	@Autowired
	private JobBuilderFactory jf;

	@Bean
	public Job jobA() {
		return jf.get("jobA").listener(listener()).incrementer(new RunIdIncrementer()).start(stepA()).build();
	}

}
