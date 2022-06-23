package uk.hpkns.dvdrentalpos.data.repositories.auth;

import org.springframework.data.repository.CrudRepository;
import uk.hpkns.dvdrentalpos.data.models.auth.CustomerToken;

import java.util.Optional;

public interface CustomerTokensRepository extends CrudRepository<CustomerToken, Integer> {

    Optional<CustomerToken> findByToken(String token);
}
