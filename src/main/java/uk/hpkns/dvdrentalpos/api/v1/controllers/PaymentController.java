package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Payment;
import uk.hpkns.dvdrentalpos.data.repositories.PaymentRepository;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController extends ModelController<Payment, Integer, PaymentRepository> {

    public PaymentController(PaymentRepository repository) {
        super(repository);
    }
}
