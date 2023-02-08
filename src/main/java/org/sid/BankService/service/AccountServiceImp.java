package org.sid.BankService.service;

import org.sid.BankService.Dto.BankAccountRequestDTO;
import org.sid.BankService.Dto.BankAccountResponseDTO;
import org.sid.BankService.Repositories.BankAccountRepository;
import org.sid.BankService.entities.BankAccount;
import org.sid.BankService.mappers.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Transactional // Spring Transational pour les methodes transaional
@Service
public class AccountServiceImp implements AccountService{
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .dateCreation(new Date())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .type(bankAccountDTO.getType())
                .build(); // Mapping Objet Objet Transfert de donner de DTO VERS ENTIT2

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        //recupereation de l'objet
      /*  BankAccountResponseDTO bankAccountResponseDTO =BankAccountResponseDTO.builder()
                .id(savedBankAccount.getId())
                .balance(savedBankAccount.getBalance())
                .currency(savedBankAccount.getCurrency())
                .dateCreation(savedBankAccount.getDateCreation())
                .type(savedBankAccount.getType())
                .build();*/
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
}
