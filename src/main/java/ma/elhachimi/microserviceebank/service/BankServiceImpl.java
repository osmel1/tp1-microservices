package ma.elhachimi.microserviceebank.service;

import ma.elhachimi.microserviceebank.dto.BankAccountResultDTO;
import ma.elhachimi.microserviceebank.dto.BankAcountRequestDTO;
import ma.elhachimi.microserviceebank.entities.BankAccount;
import ma.elhachimi.microserviceebank.mapper.AccountMapper;
import ma.elhachimi.microserviceebank.repos.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;
@Service
public class BankServiceImpl implements BankService {
    @Autowired
    BankAccountRepo bankAccountRepo;
    @Autowired
    AccountMapper mapperAccount;
    @Override
    public BankAccountResultDTO addAccount(BankAcountRequestDTO bankAcountRequestDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAcountRequestDTO.getType())
                .createdAt(LocalDate.now())
                .balance(bankAcountRequestDTO.getBalance())
                .currency("MAD")
                .build();
        BankAccount savedAccount = bankAccountRepo.save(bankAccount);
        return mapperAccount.fromBankAccount(savedAccount);
    }

    @Override
    public BankAccountResultDTO updateAccount(String id, BankAcountRequestDTO bankAcountRequestDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .type(bankAcountRequestDTO.getType())
                .createdAt(LocalDate.now())
                .balance(bankAcountRequestDTO.getBalance())
                .currency(bankAcountRequestDTO.getCurrency())
                .build();
        BankAccount savedAccount = bankAccountRepo.save(bankAccount);
        return mapperAccount.fromBankAccount(savedAccount);
    }
}
