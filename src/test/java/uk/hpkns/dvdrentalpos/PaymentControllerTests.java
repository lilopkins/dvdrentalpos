package uk.hpkns.dvdrentalpos;

import org.junit.jupiter.api.BeforeEach;
import uk.hpkns.dvdrentalpos.api.v1.controllers.PaymentController;
import uk.hpkns.dvdrentalpos.api.v1.controllers.RentalController;
import uk.hpkns.dvdrentalpos.data.models.Payment;
import uk.hpkns.dvdrentalpos.data.models.Rental;
import uk.hpkns.dvdrentalpos.data.repositories.PaymentRepository;
import uk.hpkns.dvdrentalpos.data.repositories.RentalRepository;

import java.sql.Date;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

public class PaymentControllerTests extends ModelControllerTests<Payment, Integer, PaymentRepository, PaymentController> {

    @Override
    @BeforeEach
    public void setup() {
        repository = mock(PaymentRepository.class);
        controller = new PaymentController(repository);
    }

    @Override
    protected Class<Payment> getTypeClass() {
        return Payment.class;
    }

    @Override
    protected Payment getTestObject() {
        return new Payment(
                1,
                null,
                null,
                null,
                12.34f,
                Date.from(Instant.EPOCH)
        );
    }

    @Override
    protected Payment getEditObject() {
        return new Payment(
                1,
                null,
                null,
                null,
                43.21f,
                Date.from(Instant.ofEpochSecond(5))
        );
    }

    @Override
    protected void validateChangedObject(Payment obj) {
        assertEquals(1, obj.getId(), "id incorrect");
        assertEquals(43.21f, obj.getAmount(), "amount incorrect");
        assertNull(obj.getRental(), "rental is set");
        assertNull(obj.getCustomer(), "customer is set");
        assertNull(obj.getStaff(), "staff is set");
        assertEquals(Date.from(Instant.ofEpochSecond(5)), obj.getPaymentDate(), "payment date incorrect");
    }
}
