package com.mycompany.messaging.config;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mycompany.messaging.domain.Product;
import com.mycompany.messaging.repositories.ProductRepository;

@Configuration
@EnableJpaRepositories(basePackages = "com.mycompany.messaging.repositories")
@EntityScan(basePackages = "com.mycompany.messaging.domain")
public class DatabaseConfig {

	@Autowired
	ProductRepository products;

	@Bean
	InitializingBean feedData() {
		return () -> {
			for (int i = 0; i < 20; i++) {
				Date date = Calendar.getInstance(Locale.US).getTime();
				products.save(new Product("Apple-" + i, "Apple Desc -" + i, "Daya", "Daya", date, date));
			}
		};
	}
}
