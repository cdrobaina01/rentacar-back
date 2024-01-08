package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.UserDTO;
import cu.edu.cujae.rentacarback.dto.save.UserSaveDTO;
import cu.edu.cujae.rentacarback.model.Role;
import cu.edu.cujae.rentacarback.model.User;
import cu.edu.cujae.rentacarback.repository.RoleRepository;
import cu.edu.cujae.rentacarback.repository.UserRepository;
import cu.edu.cujae.rentacarback.service.core.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> mapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(String username) {
        return userRepository.findById(username).map(user -> mapper.map(user, UserDTO.class));
    }

    @Override
    public Optional<User> internalFindById(String username) {
        return userRepository.findById(username);
    }

    @Override
    public Optional<UserDTO> create(UserSaveDTO user) {
        Optional<Role> role = roleRepository.findById(user.getRoleName());
        if (role.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapper.map(
                userRepository.save(new User(
                        user.getUsername(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getName(),
                        role.get()
                )),
                UserDTO.class
        ));
    }

    @Override
    public Optional<UserDTO> update(String username, UserSaveDTO newUser) {
        Optional<Role> role = roleRepository.findById(newUser.getRoleName());
        if (role.isEmpty()) {
            return Optional.empty();
        }
        return userRepository.findById(username).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setName(newUser.getName());
            user.setRole(role.get());
            return mapper.map(userRepository.save(user), UserDTO.class);
        });
    }

    @Override
    public Optional<UserDTO> delete(String username) {
        return userRepository.findById(username).map(user -> {
            userRepository.delete(user);
            return mapper.map(user, UserDTO.class);
        });
    }
}
