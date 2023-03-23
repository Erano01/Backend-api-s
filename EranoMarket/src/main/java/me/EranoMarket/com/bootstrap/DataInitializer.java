package me.EranoMarket.com.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import me.EranoMarket.com.model.Role;
import me.EranoMarket.com.model.User;
import me.EranoMarket.com.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner{

	private final UserRepository userRepository;

	public DataInitializer(UserRepository userRepository) {
		this.userRepository = userRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		
		User ali = new User("erano","123232323","q@gmail.com","TR","123");
		
		userRepository.save(ali);
	}

	
}
