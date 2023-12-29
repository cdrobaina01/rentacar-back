package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.PaymethodDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Paymethod;

import java.util.List;
import java.util.Optional;

public interface PaymethodService {
    List<PaymethodDTO> findAll();
    Optional<PaymethodDTO> findById(Integer id);
    Optional<PaymethodDTO> create(AuxiliarySaveDTO paymethod);
    Optional<PaymethodDTO> update(Integer id, AuxiliarySaveDTO paymethod);
    Optional<PaymethodDTO> delete(Integer id);
}
