package ma.elhachimi.microserviceebank.entities;

import ma.elhachimi.microserviceebank.enums.CompteType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class , name = "p1")
public interface AccountProjection {
    String getId();
    CompteType getType();
}
