package com.nt.jai.config;



import java.util.HashMap;

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
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.nt.jai.model.User;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
	@Autowired
	private MongoTemplate template;

	@Bean
	public ItemReader<? extends User> reader() {
		MongoItemReader<User> reader = new MongoItemReader<>();
		reader.setTemplate(template);
		reader.setTargetType(User.class);
		reader.setCollection("user");
		// reader.setQuery("{ uid: { $lt: 10} }");
		reader.setQuery("{ }");
		reader.setSort(new HashMap<String, Direction>() {
			{
				put("_id", Direction.DESC);
			}
		});
		return reader;
	}

	@Bean
	public ItemProcessor<? super User, ? extends User> processor() {

		return item->item;
	}

	@Bean
	public ItemWriter<? super User> writer() {
		FlatFileItemWriter<User> writer = new FlatFileItemWriter<>();
		writer.setResource(new FileSystemResource("E:/mongofile/usersmongodb.csv"));
		writer.setLineAggregator(new DelimitedLineAggregator<>() {
			{
				setDelimiter(",");

				setFieldExtractor(new BeanWrapperFieldExtractor<>() {
					{
						setNames(new String[] { "userId", "userName", "userRole", "userDept" });

					}
				});
			}
		});

		return writer;
	}

	@Bean
	public JobExecutionListener listener() {
		// return new MyJobListener();
		return new JobExecutionListener() {

			@Override
			public void beforeJob(org.springframework.batch.core.JobExecution je) {
				System.out.println("Starting : " + je.getStatus());
			}

			@Override
			public void afterJob(org.springframework.batch.core.JobExecution je) {
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
