package org.sid.BankService.web;

import org.sid.BankService.Dto.BankAccountRequestDTO;
import org.sid.BankService.Dto.BankAccountResponseDTO;
import org.sid.BankService.Repositories.BankAccountRepository;
import org.sid.BankService.entities.BankAccount;
import org.sid.BankService.mappers.AccountMapper;
import org.sid.BankService.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController  // http://localhost:8090/bankAccounts ----> on fait appel à springdataRest
@RequestMapping("/api")// http://localhost:8090/api/bankAccounts ----> on fait appel à ce AccountWebRestController
public class AccountWebRestController {

    private BankAccountRepository bankAccountRepository;

    private AccountService accountService;

    private AccountMapper accountMapper;



    // injection de dependance avec un constructeur pas abvec @Autowiride
    public AccountWebRestController(BankAccountRepository bankAccountRepository,AccountService accountService,AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper =accountMapper;
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
    public BankAccountResponseDTO save (@RequestBody BankAccountRequestDTO requestDto){

        return accountService.addAccount(requestDto);

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
