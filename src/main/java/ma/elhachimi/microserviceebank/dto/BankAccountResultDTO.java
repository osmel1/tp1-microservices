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
public class BankAccountResultDTO {
    private String id;
    private Double balance;
    private String currency;
    private LocalDate createdAt;
    private CompteType type;
}
