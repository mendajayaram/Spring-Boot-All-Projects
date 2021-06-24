package com.nt.jai.config;

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
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.nt.jai.model.Product;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
	

	
	@Bean
	public ItemReader<? extends Product> reader() {
		FlatFileItemReader<Product> reader=new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("productmongo.csv"));
		reader.setLineMapper(new DefaultLineMapper<>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(DELIMITER_COMMA);
				setNames("prodId","prodCode","prodCost");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
				setTargetType(Product.class);
			}});
		}});
		return reader;
	}

	
	
	@Bean
	public ItemProcessor<? super Product, ? extends Product> processor() {
		
		return (item)->{
			item.setProdDiscount(item.getProdCost()*0.12);
			item.setProdGst(item.getProdCost()*0.08);
			return item;
		};
	}


	
	
	@Autowired
	private MongoTemplate template;
	
	@Bean
	public ItemWriter<? super Product> Writer() {
		MongoItemWriter<Product> writer =new MongoItemWriter<>();
		writer.setTemplate(template);
		writer.setCollection("products");
		return writer;
	}
	@Bean
	public JobExecutionListener listener() {
		
		return new JobExecutionListener() {
			
			@Override
			public void beforeJob(JobExecution jobExecution) {
				System.out.println("Started :" +jobExecution.getStatus() );
				
			}
			
			@Override
			public void afterJob(JobExecution jobExecution) {
				System.out.println("Ending :" +jobExecution.getStatus() );
				
			}
		};
	}
	
	
	@Autowired
	private StepBuilderFactory sf;
	
	@Bean
	public Step stepA() {
		return sf.get("stepA")
				.<Product,Product>chunk(2)
		        .reader(reader())
		        .processor(processor())
		        .writer(Writer())
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
