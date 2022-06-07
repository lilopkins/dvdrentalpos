package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Staff;
import uk.hpkns.dvdrentalpos.data.repositories.StaffRepository;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController extends ModelController<Staff, Integer, StaffRepository> {

    public StaffController(StaffRepository repository) {
        super(repository);
    }
}
