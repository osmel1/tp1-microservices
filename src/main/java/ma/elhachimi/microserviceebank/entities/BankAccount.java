package ma.elhachimi.microserviceebank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.elhachimi.microserviceebank.enums.CompteType;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String id;
    private Double balance;
    private String currency;
    private LocalDate createdAt;
    private CompteType type;
    @ManyToOne
    private Customer customer;
}
