package org.sid.BankService.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.BankService.enums.AccountType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder// forme de design pathern
public class BankAccount {
    @Id
    private String id;
    private Date dateCreation;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
