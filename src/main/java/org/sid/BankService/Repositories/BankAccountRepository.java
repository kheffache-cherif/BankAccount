package org.sid.BankService.Repositories;

import org.sid.BankService.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource // permets l'utilisation
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
