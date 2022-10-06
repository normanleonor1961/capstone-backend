package norman.minicapstone.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import norman.minicapstone.dto.UserDTO;
import norman.minicapstone.model.UserRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    public UserDTO saveUser(@NonNull UserRequest newUser) {
        return null;

    }
}
