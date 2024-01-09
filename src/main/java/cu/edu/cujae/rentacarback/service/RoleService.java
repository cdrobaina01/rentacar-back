package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Role;
import cu.edu.cujae.rentacarback.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService extends CrudService<Role, String> {
    private final RoleRepository repository;

    @Override
    protected String getEntityName() {
        return "Role";
    }

    @Override
    protected JpaRepository<Role, String> repository() {
        return repository;
    }

    @Override
    protected void validateKeys(Role role) throws UniqueValueException {
        repository.findById(role.getName()).orElseThrow(uniqueValueException("Name"));
    }

    @Override
    protected Role updateData(Role role, Role data) {
        role.setName(data.getName());
        role.setDescription(data.getDescription());
        return role;
    }
}