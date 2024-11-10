package ma.elhachimi.microserviceebank.mapper;

import ma.elhachimi.microserviceebank.dto.BankAccountResultDTO;
import ma.elhachimi.microserviceebank.dto.BankAcountRequestDTO;
import ma.elhachimi.microserviceebank.entities.BankAccount;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class AccountMapper {
    public BankAccountResultDTO fromBankAccount(BankAccount bankAccount){
        return BankAccountResultDTO.builder()
                .id(bankAccount.getId())
                .type(bankAccount.getType())
                .balance(bankAccount.getBalance())
                .currency(bankAccount.getCurrency())
                .createdAt(bankAccount.getCreatedAt())
                .build();
    }
}
