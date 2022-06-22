package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Staff;

import java.util.Optional;

public interface StaffRepository extends CrudRepository<Staff, Integer>, PagingAndSortingRepository<Staff, Integer> {

    Optional<Staff> findByUsername(String username);
}
