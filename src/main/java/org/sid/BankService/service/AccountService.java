package org.sid.BankService.service;

import org.sid.BankService.Dto.BankAccountRequestDTO;
import org.sid.BankService.Dto.BankAccountResponseDTO;




public interface AccountService {
      BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

}
