package norman.minicapstone.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import norman.minicapstone.dto.UserDTO;
import norman.minicapstone.model.UserRequest;
import norman.minicapstone.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PutMapping("/signup")
    public UserDTO registerUser(@RequestBody @NonNull UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

    @DeleteMapping("/{email}")
    public String deletUser(@PathVariable String email){
        return userService.deleteUser(email);
    }

    @PostMapping("/update/{oldEmail}")
    public UserDTO updateUser(@PathVariable String oldEmail, @RequestBody UserRequest userRequest) {
        return userService.updateUser(oldEmail, userRequest);
    }

    @PostMapping("/login")
    public UserDTO loginUser(@RequestBody @NonNull UserRequest userRequest) {
        return userService.loginUser(userRequest);
    }

    @PostMapping("/loginByProvider/{email}")
    public UserDTO loginByProvider(@PathVariable String email) {
        return userService.loginByProvider(email);
    }
}
