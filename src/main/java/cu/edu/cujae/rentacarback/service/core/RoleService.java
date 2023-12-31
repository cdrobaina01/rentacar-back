package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.RoleDTO;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<RoleDTO> findAll();
    Optional<RoleDTO> findById(String name);
    Optional<RoleDTO> create(RoleDTO role);
    Optional<RoleDTO> update(String name, RoleDTO role);
    Optional<RoleDTO> delete(String name);
}
