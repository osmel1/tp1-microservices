package ma.elhachimi.microserviceebank.service;

import ma.elhachimi.microserviceebank.dto.BankAccountResultDTO;
import ma.elhachimi.microserviceebank.dto.BankAcountRequestDTO;

public interface BankService {
    BankAccountResultDTO addAccount(BankAcountRequestDTO bankAcountRequestDTO);

    BankAccountResultDTO updateAccount(String id, BankAcountRequestDTO bankAcountRequestDTO);
}
