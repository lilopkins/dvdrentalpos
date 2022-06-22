package uk.hpkns.dvdrentalpos.data.repositories.auth;

import org.springframework.data.repository.CrudRepository;
import uk.hpkns.dvdrentalpos.data.models.auth.StaffToken;

import java.util.Optional;

public interface StaffTokensRepository extends CrudRepository<StaffToken, Integer> {

    Optional<StaffToken> findByToken(String token);
}
