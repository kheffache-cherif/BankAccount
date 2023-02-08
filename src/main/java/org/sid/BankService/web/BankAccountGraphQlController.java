package org.sid.BankService.web;


import org.sid.BankService.Dto.BankAccountRequestDTO;
import org.sid.BankService.Dto.BankAccountResponseDTO;
import org.sid.BankService.Repositories.BankAccountRepository;
import org.sid.BankService.entities.BankAccount;
import org.sid.BankService.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService
;    @QueryMapping
    //localhost:8090/graphiql
    public List<BankAccount> accountsList(){
      return   bankAccountRepository.findAll();
    }
    @QueryMapping
    //localhost:8090/graphiql
    public BankAccount accountsById(@Argument String id){
        return  bankAccountRepository.findById(id).orElseThrow(()->new
                RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping // pour toutes les operations de modification
    public BankAccountResponseDTO addBankAccount (@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
}
/*
public record BankAccountDTO(Double balace, String type,String currency){

}*/

