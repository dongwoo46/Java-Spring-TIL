package com.MongoSpring.MongoSpring;

import com.MongoSpring.MongoSpring.category.Category;
import com.MongoSpring.MongoSpring.category.CategoryRepository;
import com.MongoSpring.MongoSpring.product.Product;
import com.MongoSpring.MongoSpring.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository repository, CategoryRepository categoryRepository) {

		return args -> {
			var category = Category.builder()
					.name("cat 1")
					.description("cat 1")
					.build();

//			var category2 = Category.builder()
//					.name("cat 2")
//					.description("cat 2")
//					.build();
//			categoryRepository.insert(category2);
			categoryRepository.insert(category);
			var product = Product.builder()
					.name("iphone")
					.description("smart phone")
					.category(category)
					.build();
			repository.insert(product);
		};
	}
}
