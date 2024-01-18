package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.User;
import cu.edu.cujae.rentacarback.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("security/user")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN')")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{username}")
    public User getById(@PathVariable String username) {
        return userService.findById(username);
    }

    @PostMapping
    public User create(@RequestBody @Valid User user) throws UniqueValueException {
        return userService.create(user);
    }

    @PutMapping("/{username}")
    public User update(@PathVariable String username, @RequestBody User user) throws UniqueValueException {
        return userService.update(username, user);
    }

    @DeleteMapping("/{username}")
    public User delete(@PathVariable String username) {
        return userService.delete(username);
    }
}
