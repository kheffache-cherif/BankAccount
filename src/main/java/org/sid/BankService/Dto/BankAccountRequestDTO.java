package org.sid.BankService.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.BankService.enums.AccountType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder// forme de design pathern
public class BankAccountRequestDTO {
        private Double balance;
        private String currency;
        private AccountType type;
}
