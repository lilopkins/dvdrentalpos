package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>, PagingAndSortingRepository<Payment, Integer> {
}
