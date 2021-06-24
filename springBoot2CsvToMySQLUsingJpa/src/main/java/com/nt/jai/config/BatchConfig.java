package com.nt.jai.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nt.jai.listener.MyJobListener;
import com.nt.jai.model.Product;
import com.nt.jai.processor.ProductProcessor;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jf;

	@Autowired
	private StepBuilderFactory sf;

	@Bean
	public ItemReader<Product> reader() {
		FlatFileItemReader<Product> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("products.csv"));
		reader.setLineMapper(new DefaultLineMapper<>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setDelimiter(DELIMITER_COMMA);
						setNames("prodId", "prodCode", "prodCost");
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {
					{
						setTargetType(Product.class);
					}
				});
			}
		});
		return reader;
	}

	@Bean
	public ItemProcessor<Product, Product> processor() {
		return new ProductProcessor();
	}

	@Autowired
	private EntityManagerFactory emf;

	@Bean
	public ItemWriter<Product> writer() {
		JpaItemWriter<Product> writer = new JpaItemWriter<>();
		writer.setEntityManagerFactory(emf);
		return writer;
	}

	@Bean
	public JobExecutionListener listener() {
		return new MyJobListener();
	}

	@Bean
	public Step stepA() {
		return sf.get("stepA")// name
				.<Product, Product>chunk(3)// I,O,chunk
				.reader(reader()).processor(processor()).writer(writer()).build();
	}

	@Bean
	public Job jobA() {
		return jf.get("jobA")// name
				.listener(listener()).incrementer(new RunIdIncrementer()).start(stepA()).build();
	}

}
