package com.bcf.sqs;

import com.bcf.sqs.service.Publisher;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqsApplication.class, args);
	}


	// ////
	@Bean
	public ApplicationRunner runner(Publisher publisher) {
		return args -> {
			Thread.sleep(3000);
			for (int i = 0; i < 10; i++) {
				publisher.publishMessage(String.valueOf(i));
			}
		};
	}

}
