package ma.elhachimi.microserviceebank.repos;

import ma.elhachimi.microserviceebank.entities.BankAccount;
import ma.elhachimi.microserviceebank.entities.Customer;
import ma.elhachimi.microserviceebank.enums.CompteType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepo extends JpaRepository<Customer,String> {
}
