package ma.elhachimi.microserviceebank.repos;

import ma.elhachimi.microserviceebank.entities.BankAccount;
import ma.elhachimi.microserviceebank.enums.CompteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepo extends JpaRepository<BankAccount,String> {
    List<BankAccount> findByType(CompteType type);
}
