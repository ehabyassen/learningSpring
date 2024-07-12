package com.luv2code.aopDemo;

import com.luv2code.aopDemo.entity.Account;
import com.luv2code.aopDemo.repository.AccountRepository;
import com.luv2code.aopDemo.repository.MembershipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountRepository accountRepository, MembershipRepository membershipRepository) {
		return runner -> {
			//demoBeforeAdvice(accountRepository, membershipRepository);
			//demoAfterReturningAdvice(accountRepository);
			//demoAfterThrowingAdvice(accountRepository);
			demoAfterAdvice(accountRepository);
		};
	}

	private void demoBeforeAdvice(AccountRepository accountRepository, MembershipRepository membershipRepository) {
		accountRepository.addAccount();
		accountRepository.getAccount();
		accountRepository.setAccount();
		membershipRepository.addMembershipAccount(new Account("John", "Platinum"), true, "x1234");
	}

	private void demoAfterReturningAdvice(AccountRepository accountRepository) {
		List<Account> accounts = accountRepository.findAccounts(false);
		System.out.println(accounts);
	}

	private void demoAfterThrowingAdvice(AccountRepository accountRepository) {
		try {
			List<Account> accounts = accountRepository.findAccounts(true);
		} catch (Exception e) {
			System.out.println("Caught exception: " + e.getMessage());
		}
	}

	private void demoAfterAdvice(AccountRepository accountRepository) {
		accountRepository.findAccounts(false);

		System.out.println("#".repeat(50));

		try {
			accountRepository.findAccounts(true);
		} catch (Exception e) {
			System.out.println("Caught Exception in After Advice Demo: " + e.getMessage());
		}
	}
}
