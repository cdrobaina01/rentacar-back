package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Role;
import cu.edu.cujae.rentacarback.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/security/role")
@PreAuthorize("hasAnyRole('ADMIN')")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public List<Role> getAll() {
        return roleService.findAll();
    }

    @GetMapping("/{name}")
    public Role getById(@PathVariable String name) {
        return roleService.findById(name);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public Role create(@RequestBody @Valid Role role) throws UniqueValueException {
        return roleService.create(role);
    }

    @PutMapping("/{name}")
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public Role update(@PathVariable String name, @RequestBody @Valid Role role) throws UniqueValueException {
        return roleService.update(name, role);
    }

    @DeleteMapping("/{name}")
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public Role delete(@PathVariable String name) {
        return roleService.delete(name);
    }
}
