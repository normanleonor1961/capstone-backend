package norman.minicapstone.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import norman.minicapstone.dto.UserDTO;
import norman.minicapstone.model.UserRequest;
import norman.minicapstone.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public UserDTO registerUser(@RequestBody @NonNull UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

}
