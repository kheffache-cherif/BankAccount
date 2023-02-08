package org.sid.BankService.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.BankService.enums.AccountType;
import java.util.Date;
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class BankAccountResponseDTO {
        private String id;
        private Date dateCreation;
        private Double balance;
        private String currency;
        private AccountType type;

}
