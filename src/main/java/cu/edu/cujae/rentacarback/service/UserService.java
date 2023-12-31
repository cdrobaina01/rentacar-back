package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.User;
import cu.edu.cujae.rentacarback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService extends CrudService<User, String> {
    private final UserRepository repository;
    private final RoleService roleService;

    @Override
    protected String getEntityName() {
        return "User";
    }

    @Override
    protected String getKeyName() {
        return "Username";
    }

    @Override
    protected JpaRepository<User, String> repository() {
        return repository;
    }

    @Override
    protected String getKey(User user) {
        return user.getUsername();
    }

    @Override
    protected void validateExistingForeignKeys(User user) throws UniqueValueException {
        roleService.findById(user.getRole().getName());
    }

    @Override
    protected User updateData(User user, User data) {
        user.setRole(data.getRole());
        user.setName(data.getName());
        user.setPassword(data.getPassword());
        user.setEmail(data.getEmail());
        return user;
    }

    public Optional<User> internalFindById(String username) {
        return repository.findById(username);
    }
}
