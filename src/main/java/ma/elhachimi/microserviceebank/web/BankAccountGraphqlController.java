package ma.elhachimi.microserviceebank.web;

import ma.elhachimi.microserviceebank.dto.BankAccountResultDTO;
import ma.elhachimi.microserviceebank.dto.BankAcountRequestDTO;
import ma.elhachimi.microserviceebank.entities.BankAccount;
import ma.elhachimi.microserviceebank.repos.BankAccountRepo;
import ma.elhachimi.microserviceebank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphqlController {
    @Autowired
    private BankAccountRepo bankAccountRepo;
    @Autowired
    BankService service;
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepo.findAll();
    }
    @QueryMapping
    public BankAccount accountById(@Argument String id){
        return bankAccountRepo.findById(id).orElseThrow(()->new RuntimeException(String.format("Account with id %s not found",id)));
    }
    @MutationMapping
    public BankAccountResultDTO addAccount(@Argument BankAcountRequestDTO bankAccount){
        return service.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResultDTO updateAccount(@Argument String id,@Argument BankAcountRequestDTO bankAccount){
        return service.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public void deleteAccount(@Argument String id){
        bankAccountRepo.deleteById(id);
    }
}
