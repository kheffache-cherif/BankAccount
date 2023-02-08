package org.sid.BankService.entities;

import org.sid.BankService.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;
 // Spring data rest dispose de projection pour affichage sur l'interface
//http://localhost:8090/bankAccounts?projection=p1
@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
    public  String getId();
    public AccountType getType();
}
