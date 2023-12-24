package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Paymethod;

import java.util.List;
import java.util.Optional;

public interface PaymethodService {
    List<Paymethod> findAll();
    Optional<Paymethod> findById(Integer id);
    Paymethod create(Paymethod paymethod);
    Optional<Paymethod> update(Integer id, Paymethod paymethod);
    Optional<Paymethod> delete(Integer id);
}
