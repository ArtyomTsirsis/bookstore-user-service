package com.example.bookstoreuserservice;

import com.example.bookstoreuserservice.domain.User;
import com.example.bookstoreuserservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreUserServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner Users(UserRepository userRepository) {
		return args -> {
			userRepository.save(new User("Artjoms", "password1", true));
			userRepository.save(new User("JohnDoe", "password2", false));
			userRepository.save(new User("admin", "admin", true));
		};
	}

}
