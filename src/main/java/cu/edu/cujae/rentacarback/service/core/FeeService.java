package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Fee;

import java.util.List;
import java.util.Optional;

public interface FeeService {
    List<Fee> findAll();
    Optional<Fee> findById(Integer id);
    Fee create(Fee fee);
    Optional<Fee> update(Integer id, Fee fee);
    Optional<Fee> delete(Integer id);
}
