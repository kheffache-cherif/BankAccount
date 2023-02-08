package org.sid.BankService.web;

import org.sid.BankService.Repositories.BankAccountRepository;
import org.sid.BankService.entities.BankAccount;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class AccountWebRestController {

    private BankAccountRepository bankAccountRepository;


    // injection de dependance avec un constructeur pas abvec @Autowiride
    public AccountWebRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @GetMapping("/bankAccounts") // norme RESTFull s à la fin
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}") // norme RESTFull s à la fin
    public BankAccount bankAccounts(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("le compte %s est introuvable ",id)));
    }
    @PostMapping("/bankAccounts")
    public  BankAccount save (@RequestBody BankAccount bankAccount){
         if(bankAccount.getId()==null) bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);

    }
    @PutMapping ("/bankAccounts/{id}")
    public  BankAccount update  (@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
       if(bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getDateCreation()!=null)  account.setDateCreation(new Date());
        if(bankAccount.getType()!=null) account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());


        return bankAccountRepository.save(account);

    }
    @DeleteMapping("/bankAccounts/{id}") // norme RESTFull s à la fin
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
