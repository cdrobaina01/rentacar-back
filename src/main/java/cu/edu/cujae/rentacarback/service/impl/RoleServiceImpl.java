package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.RoleDTO;
import cu.edu.cujae.rentacarback.model.Role;
import cu.edu.cujae.rentacarback.repository.RoleRepository;
import cu.edu.cujae.rentacarback.service.core.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<RoleDTO> findAll() {
        return roleRepository.findAll().stream()
                .map(role -> mapper.map(role, RoleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RoleDTO> findById(String name) {
        return roleRepository.findById(name).map(role -> mapper.map(role, RoleDTO.class));
    }

    @Override
    public Optional<RoleDTO> create(RoleDTO role) {
        return Optional.of(mapper.map(
                roleRepository.save(new Role(
                        role.getName(),
                        role.getDescription(),
                        null
                )),
                RoleDTO.class
        ));
    }

    @Override
    public Optional<RoleDTO> update(String name, RoleDTO newRole) {
        return roleRepository.findById(name).map(role -> {
            role.setName(newRole.getName());
            role.setDescription(newRole.getDescription());
            return mapper.map(roleRepository.save(role), RoleDTO.class);
        });
    }

    @Override
    public Optional<RoleDTO> delete(String name) {
        return roleRepository.findById(name).map(role -> {
            roleRepository.delete(role);
            return mapper.map(role, RoleDTO.class);
        });
    }
}
