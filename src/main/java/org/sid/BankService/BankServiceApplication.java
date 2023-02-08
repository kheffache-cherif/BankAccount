package org.sid.BankService;

import org.sid.BankService.Repositories.BankAccountRepository;
import org.sid.BankService.entities.BankAccount;
import org.sid.BankService.enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceApplication.class, args);
	}
	// bean pour creer des objet au demarrage
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return args -> {
			for (int i = 0; i <10 ; i++) {
				// .builder est le pathern bulder et on initialise les objets
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
						.balance(10000+Math.random()*90000)
						.dateCreation(new Date())
						.currency("EURO")

						.build();
				bankAccountRepository.save(bankAccount);
				
			}
		};
	}

}
