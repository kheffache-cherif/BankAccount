package org.sid.BankService.Repositories;

import org.sid.BankService.entities.BankAccount;
import org.sid.BankService.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


// permets la creation d'un web servicerestFull qui gere l'entité BankAccount avec les creation des get, post delete put
// pour test
@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    //http://localhost:8090/bankAccounts/search/findByType?type=SAVING_ACCOUNT

    @RestResource(path = "/byType")  // avec cette anotation on chage l'appel :http://localhost:8090/bankAccounts/search/byType?t=SAVING_ACCOUNT
    List<BankAccount> findByType(@Param("t") AccountType type);
}
