package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.UserDTO;
import cu.edu.cujae.rentacarback.dto.save.UserSaveDTO;
import cu.edu.cujae.rentacarback.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAll();
    Optional<UserDTO> findById(String username);
    Optional<User> internalFindById(String username);
    Optional<UserDTO> create(UserSaveDTO user);
    Optional<UserDTO> update(String username, UserSaveDTO newUser);
    Optional<UserDTO> delete(String username);
}
