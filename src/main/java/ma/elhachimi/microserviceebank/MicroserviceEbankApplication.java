package ma.elhachimi.microserviceebank;

import ma.elhachimi.microserviceebank.entities.BankAccount;
import ma.elhachimi.microserviceebank.entities.Customer;
import ma.elhachimi.microserviceebank.enums.CompteType;
import ma.elhachimi.microserviceebank.repos.BankAccountRepo;
import ma.elhachimi.microserviceebank.repos.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class MicroserviceEbankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEbankApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepo bankAccountRepo , CustomerRepo customerRepo){
        return args -> {
            List.of("Mehdi","Omar","Hatim","Mina").stream().forEach(name->{
                Customer customer = Customer.builder()
                        .name(name)
                        .build();
                customerRepo.save(customer);
                for (int i =0;i<10;i++){
                    BankAccount compte =  BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .balance(Math.random()*10000)
                            .type(Math.random()>0.5?CompteType.CURRENT_ACCOUNT:CompteType.SAVING_ACCOUNT)
                            .createdAt(LocalDate.now())
                            .currency("MAD")
                            .customer(customer)
                            .build();
                    bankAccountRepo.save(compte);
                }
            });


        };
    }
}
