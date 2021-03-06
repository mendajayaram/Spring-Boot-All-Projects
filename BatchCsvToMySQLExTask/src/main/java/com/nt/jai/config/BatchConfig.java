package com.nt.jai.config;



import javax.sql.DataSource;

import org.springframework.batch.core.Job;
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
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.nt.jai.model.Employee;
import com.nt.jai.processor.Myprocessor;
@EnableBatchProcessing
@Configuration
public class BatchConfig {


@Autowired
private JobBuilderFactory jf;

@Autowired
private StepBuilderFactory sf;
@Bean
public Step StepA() {
	return sf.get("StepA")
			.<Employee,Employee>chunk(2)
			.reader(reader())
			.processor(processor())
			.writer(Writer())
	        .build();
}
@Bean
public Job jobA() {
return	jf.get("jobA")
	.listener(listener())
	.incrementer(new RunIdIncrementer())
	.start(StepA())
	.build();

	
}
@Bean
public JobExecutionListener listener() {
	
	return new JobExecutionListener() {
		
		@Override
		public void beforeJob(JobExecution jobExecution) {
			System.out.println("Starting :"+jobExecution.getStatus());
		}
		
		@Override
		public void afterJob(JobExecution jobExecution) {
			System.out.println("Ending :"+jobExecution.getStatus());
			
		}
	};
}
@Bean
public FlatFileItemReader<? extends Employee> reader() {
	FlatFileItemReader<Employee> reader=new FlatFileItemReader<>();
	reader.setResource(new ClassPathResource("Employee.csv"));
	reader.setLineMapper(new DefaultLineMapper<>(){{
		setLineTokenizer(new DelimitedLineTokenizer() {{
			setNames("empid","ename","esal");
		}});
		setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
			setTargetType(Employee.class);
		}});
	}});
	
	
	return reader;
}
@Bean
public ItemProcessor<? super Employee, ? extends Employee> processor() {
	// TODO Auto-generated method stub
	return new Myprocessor();
}

@Bean
public JdbcBatchItemWriter<? super Employee> Writer() {
	JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter<>();
	writer.setDataSource(dataSource());
	writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());

	writer.setSql("INSERT INTO EMPTAB(empid,ename,esal,hra,ta)VALUES (:empid,:ename,:esal,:hra,:ta)");
	return writer;
}

@Bean
public DataSource dataSource() {
	DriverManagerDataSource ds=new DriverManagerDataSource();
	ds.setDriverClassName("com.mysql.jdbc.Driver");
	ds.setUrl("jdbc:mysql://localhost:3306/boot9am");
	ds.setUsername("hapbco");
    ds.setPassword("hapbco");
	return ds;
}



}
