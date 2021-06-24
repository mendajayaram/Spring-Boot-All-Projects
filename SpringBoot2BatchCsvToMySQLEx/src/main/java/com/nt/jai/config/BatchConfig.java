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

import com.nt.jai.model.Product;
@EnableBatchProcessing
@Configuration
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jf;
	@Autowired
	private StepBuilderFactory sf;
	@Bean
	public Job jobA() {
	return	jf.get("JobA")
		.listener(listener())
		.incrementer(new RunIdIncrementer())
		.start(stepA())
		.build();
	

		
		
	}
	@Bean
	public Step stepA() {
		
		return sf.get("StepA")
				.<Product,Product>chunk(3)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
				
				
	}

	@Bean
	public FlatFileItemReader<? extends Product> reader() {
		FlatFileItemReader<Product> reader=new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("product.csv"));
		reader.setLineMapper(new DefaultLineMapper<>(){{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setNames("prodId","prodCode","prodCost");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<Product>() {{
				setTargetType(Product.class);
		}});
		
		}});
		
		return reader;
	}

	
@Bean
public ItemProcessor<? super Product, ? extends Product> processor() {
		
		return Item->Item;
	}
@Bean
public JdbcBatchItemWriter<? super Product> writer() {
		
		JdbcBatchItemWriter<Product>writer=new JdbcBatchItemWriter<>();
		writer.setDataSource(dataSource());
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Product>());
		writer.setSql("INSERT INTO Products (PID,PNAME,PCOST,GST,DISC) VALUES (:prodId,:prodCode,:prodCost,:gst,:disc)");
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
	@Bean
	public JobExecutionListener listener() {
		
		return new JobExecutionListener() {
			
			@Override
			public void beforeJob(JobExecution jobExecution) {
			System.out.println("Starting :"+ jobExecution.getStatus() );
				
			}
			
			@Override
			public void afterJob(JobExecution jobExecution) {
				System.out.println("Comleted :"+jobExecution.getStatus());
				
			}
		};
	}


	
}
