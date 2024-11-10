package ma.elhachimi.microserviceebank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.elhachimi.microserviceebank.enums.CompteType;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAcountRequestDTO {
    private Double balance;
    private String currency;
    private CompteType type;
}
