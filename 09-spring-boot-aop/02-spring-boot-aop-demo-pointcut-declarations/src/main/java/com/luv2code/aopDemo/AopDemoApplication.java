package com.luv2code.aopDemo;

import com.luv2code.aopDemo.entity.Account;
import com.luv2code.aopDemo.entity.Trainer;
import com.luv2code.aopDemo.repository.AccountRepository;
import com.luv2code.aopDemo.repository.MembershipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountRepository accountRepository, MembershipRepository membershipRepository) {
		return runner -> {
			demoBeforeAdvice(accountRepository, membershipRepository);
		};
	}

	private void demoBeforeAdvice(AccountRepository accountRepository, MembershipRepository membershipRepository) {
		accountRepository.addAccount();
		accountRepository.getAccount();
		accountRepository.setAccount();
		membershipRepository.addMembershipAccount(new Account(), true, "x1234", new Trainer());
	}
}
