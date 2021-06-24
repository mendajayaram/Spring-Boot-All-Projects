package com.nt.jai.config;

import javax.sql.DataSource;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.batch.core.Job;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import com.nt.jai.model.User;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
	public ItemReader<User> reader() {

		JdbcCursorItemReader<User> reader = new JdbcCursorItemReader<>();
		reader.setDataSource(dataSource);
		reader.setSql("SELECT UID,UNAME,UROLE,UDEPT FROM USERTAB");
		// reader.setRowMapper(new UserRowMapper());
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
	public ItemWriter<User> writter() {
		FlatFileItemWriter<User> writter = new FlatFileItemWriter<>();
		writter.setResource(new FileSystemResource("E:/MSQTOCSV/users.csv"));
		writter.setLineAggregator(new DelimitedLineAggregator<>() {
			{
				setDelimiter(",");
				setFieldExtractor(new BeanWrapperFieldExtractor<>() {
					{
						setNames(new String[] { "userId", "userName", "userRole", "userDept" });
					}
				});
			}
		});
		return writter;
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
		
	return sf.get("stepA")
			.<User,User>chunk(3)
			.reader(reader())
			.processor(processor())
			.writer(writter())
			.build();
	 
 }
	@Autowired
	private JobBuilderFactory jf;
	
	@Bean
	public Job jobA() {
		return jf.get("jobA")
				.listener(listener())
				.incrementer(new RunIdIncrementer())
				.start(stepA())
				.build();
		
	}
}
