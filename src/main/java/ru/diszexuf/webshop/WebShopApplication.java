package ru.diszexuf.webshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.diszexuf.webshop.model.Role;
import ru.diszexuf.webshop.model.User;
import ru.diszexuf.webshop.repository.IUserRepository;
import ru.diszexuf.webshop.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class WebShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);

	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, IUserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles= new HashSet<>();
			roles.add(adminRole);

			User admin = new User(1L, "admin", passwordEncoder.encode("password"), roles);

			userRepository.save(admin);
		};
	}

}
