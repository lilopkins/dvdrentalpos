package uk.hpkns.dvdrentalpos.data.repositories.auth;

import org.springframework.data.repository.CrudRepository;
import uk.hpkns.dvdrentalpos.data.models.auth.CustomerLogin;

import java.util.Optional;

public interface CustomerLoginsRepository extends CrudRepository<CustomerLogin, Integer> {

    Optional<CustomerLogin> findByUsername(String username);
}
