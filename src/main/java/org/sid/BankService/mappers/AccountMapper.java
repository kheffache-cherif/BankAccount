package org.sid.BankService.mappers;

import org.sid.BankService.Dto.BankAccountRequestDTO;
import org.sid.BankService.Dto.BankAccountResponseDTO;
import org.sid.BankService.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    //Possibilité d'utiliser modelMapper ou partir nsur BeanUtils
    // Il faut l'injecter dan le service et le controller


    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
