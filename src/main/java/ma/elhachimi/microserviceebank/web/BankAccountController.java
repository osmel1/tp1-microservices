package ma.elhachimi.microserviceebank.web;

import ma.elhachimi.microserviceebank.dto.BankAccountResultDTO;
import ma.elhachimi.microserviceebank.dto.BankAcountRequestDTO;
import ma.elhachimi.microserviceebank.entities.BankAccount;
import ma.elhachimi.microserviceebank.repos.BankAccountRepo;
import ma.elhachimi.microserviceebank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BankAccountController {
    @Autowired
    BankService service;
    @Autowired
    BankAccountRepo bankAccountRepo;
    @GetMapping("/bankAccounts")
    public List<BankAccount> getBankAccounts(){
        return  bankAccountRepo.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount getBankAccount(@PathVariable String id){
        return  bankAccountRepo.findById(id).orElseThrow(()->
                new RuntimeException(String.format("Account %s not found.",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResultDTO save(@RequestBody BankAcountRequestDTO bankAccount){
        return service.addAccount(bankAccount);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount bankAccount1 = bankAccountRepo.findById(id).orElseThrow(()->
                new RuntimeException(String.format("Account %s not found.",id)));
       if(bankAccount.getBalance()!=null) bankAccount1.setBalance(bankAccount.getBalance());
       if(bankAccount.getType()!=null)  bankAccount1.setType(bankAccount.getType());
       if(bankAccount.getCreatedAt()!=null)  bankAccount1.setCreatedAt(bankAccount.getCreatedAt());
       if(bankAccount.getCurrency()!=null)  bankAccount1.setCurrency(bankAccount.getCurrency());
       return bankAccountRepo.save(bankAccount1);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
         bankAccountRepo.deleteById(id);
    }
}
